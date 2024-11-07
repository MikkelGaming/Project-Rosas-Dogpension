package MikkelGaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VetDaoImpl implements VetDaoInterface{

    /**
     * Reads and prints a vet from the database by the ID.
     * @param id
     * @return true if the vet exists.
     * @throws Exception
     */
    @Override
    public boolean readVet(int id) throws Exception {
        String sql = "SELECT * FROM dbo.tblVeterinarians WHERE fldVetID = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String name = (rs.getString(2));
            String phone = (rs.getString(3));
            String email = (rs.getString(4));

            System.out.printf("Veterinarian: \n[%d] \nName: %s\nPhone number: %s\nEmail: %s\n",
                    id, name, phone, email);

            return true;
        } else {
            System.out.println("No Vet found with ID: " + id);
            return false;
        }
    }

    /**
     * Reads vet by ID from the database and returns the details/data.
     * @param id
     * @return String containing the vet data.
     * @throws Exception
     */
    @Override
    public String printVet(int id) throws Exception {
        String sql = "SELECT * FROM dbo.tblVeterinarians WHERE fldVetID = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String name = (rs.getString(2));
            String phone = (rs.getString(3));
            String email = (rs.getString(4));

            return String.format("[%d] \nName: %s\nPhone Number: %s\nEmail: %s",
                    id, name, phone, email);
        } else {
            System.out.println("No Schedule found with ID: " + id);
            return "None";
        }
    }

    /**
     * Prints all vets to the console from the database.
     * @throws Exception
     */
    @Override
    public void readAllVets() throws Exception {
        String sql = "SELECT * FROM dbo.tblVeterinarians";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        System.out.println("--- All vets ---");
        System.out.println("[ID], Name, Phone Number, Email");

        boolean hasVets = false;
        while (rs.next()) {
            hasVets = true;

            int id = (Integer.parseInt(rs.getString(1)));
            String name = (rs.getString(2));
            String phone = (rs.getString(3));
            String email = (rs.getString(4));

            System.out.printf("[%d], %s, %s, %s\n", id, name, phone, email);
        }
        if (!hasVets) {
            System.out.println("No vets found.");
        }
    }
}
