package MikkelGaming;

import java.sql.*;

public class DogDogDaoImpl implements DogDaoInterface {

    @Override
    public void createDog(Dog dog) throws Exception {
        String sql = "INSERT INTO dbo.tblDogs VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dog.getCustomerID());
        pstmt.setString(2, dog.getName());
        pstmt.setDate(3, dog.getBirthday());
        pstmt.setString(4, dog.getRace());
        pstmt.setString(5, dog.getSpecialRequirements());
        pstmt.setInt(6, dog.getPreferredVetID());
        pstmt.setInt(7, dog.getWeight());
        pstmt.setInt(8, dog.getExpectedStay());
        pstmt.setInt(9, dog.getFeedingID());
        pstmt.setString(10, dog.getVaccines());
        pstmt.setString(11, dog.getFleaTreatment());
        pstmt.setString(12, dog.getInsurance());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    @Override
    public void updateDog(Dog dog) throws Exception {
        String sql = "UPDATE dbo.tblDogs SET " +
                "fldCustomerID = ?," +
                "fldName = ?," +
                "fldBirthday = ?," +
                "fldRace = ?," +
                "fldSpecialRequirements = ?," +
                "fldPreferredVetID = ?," +
                "fldWeight = ?," +
                "fldExpectedStay = ?," +
                "fldFeedingID = ?," +
                "fldVaccines = ?," +
                "fldFleaTreatment = ?," +
                "fldInsurance = ? WHERE fldID = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dog.getCustomerID());
        pstmt.setString(2, dog.getName());
        pstmt.setDate(3, dog.getBirthday());
        pstmt.setString(4, dog.getRace());
        pstmt.setString(5, dog.getSpecialRequirements());
        pstmt.setInt(6, dog.getPreferredVetID());
        pstmt.setInt(7, dog.getWeight());
        pstmt.setInt(8, dog.getExpectedStay());
        pstmt.setInt(9, dog.getFeedingID());
        pstmt.setString(10, dog.getVaccines());
        pstmt.setString(11, dog.getFleaTreatment());
        pstmt.setString(12, dog.getInsurance());
        pstmt.setInt(13, dog.getId());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog updated successfully.");
        } else {
            System.out.println("Failed to update the dog.");
        }
    }

    @Override
    public boolean readDog(String name) throws Exception{
        String sql = "SELECT fldDogID, fldCustomerID, fldName FROM dbo.tblDogs WHERE fldName = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("--- Matches ---");
        System.out.println("[ID] Name, CustomerID");
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setCustomerID(Integer.parseInt(rs.getString(2)));
            dog.setName(rs.getString(3));

            System.out.printf("[%d] %s, %d\n", dog.getId(), dog.getName(), dog.getCustomerID());

            return true;
        } else {
            System.out.println("No Dog found with the name: " + name);
            return false;
        }
    }

    @Override
    public boolean readDog(int id) throws Exception{

        FeedingDaoInterface feedingDao = new FeedingDaoImpl();
        VetDaoInterface vetDao = new VetDaoImpl();

        String sql = "SELECT * FROM dbo.tblDogs WHERE fldDogID = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setCustomerID(Integer.parseInt(rs.getString(2)));
            dog.setName(rs.getString(3));
            dog.setBirthday(rs.getDate(4));
            dog.setRace(rs.getString(5));
            dog.setSpecialRequirements(rs.getString(6));
            dog.setPreferredVetID(rs.getInt(7));
            dog.setWeight(rs.getInt(8));
            dog.setExpectedStay(rs.getInt(9));
            dog.setFeedingID(rs.getInt(10));
            dog.setVaccines(rs.getString(11));
            dog.setFleaTreatment(rs.getString(12));
            dog.setInsurance(rs.getString(13));

            System.out.printf("---- [%d] %s ----\nCustomerID: %d\nBirthday: %s\nRace: %s\n-- Special Requirements --\n%s\n-- Veterinarian --\n%s\n-- Weight --\n%d" +
                            "\n-- Expected Stay --\n%d hours\n-- Feeding Schedule --\n%s\n-- Vaccines --\n%s\n-- Flea treatment --\n%s\n -- Insurance --\n%s\n",
                    dog.getId(), dog.getName(), dog.getCustomerID(), dog.getBirthday().toString(), dog.getRace(), dog.getSpecialRequirements(),
                    vetDao.printVet(dog.getPreferredVetID()), dog.getWeight(), dog.getExpectedStay(), feedingDao.printSchedule(dog.getFeedingID()), dog.getVaccines(),
                    dog.getFleaTreatment(), dog.getInsurance());

            return true;
        } else {
            System.out.println("No Dog found with ID: " + id);
            return false;
        }
    }

    @Override
    public void readAllDogs() throws Exception{
        String sql = "SELECT fldDogID, fldName, fldCustomerID FROM dbo.tblDogs";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        System.out.println("--- All Dogs ---");
        System.out.println("[ID] Name, CustomerID");

        boolean hasDogs = false;
        while (rs.next()) {
            hasDogs = true;
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setName(rs.getString(2));
            dog.setCustomerID(Integer.parseInt(rs.getString(3)));
            System.out.println(dog.getId()+" "+ dog.getName()+dog.getCustomerID());
            System.out.printf("[%d] %s, %d\n", dog.getId(), dog.getName(), dog.getCustomerID());
        }
        if (!hasDogs) {
            System.out.println("No dogs found.");
        }
    }

    public void readAllDogsIdOnly() throws Exception{
        String sql = "SELECT fldDogID, fldName FROM dbo.tblDogs";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogs = false;
        while (rs.next()) {
            hasDogs = true;
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setName(rs.getString(2));
            System.out.printf("[%d] %s\n", dog.getId(), dog.getName());
        }
        if (!hasDogs) {
            System.out.println("No dogs found.");
        }
    }

    @Override
    public void deleteDog(int id) throws Exception{
        String sql = "DELETE FROM dbo.tblDogs WHERE fldDogID = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog was deleted successfully.");
        } else {
            System.out.println("Failed to locate the dog.");
        }
    }
}


