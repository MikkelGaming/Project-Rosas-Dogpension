package MikkelGaming;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDaoInterface {

    /**
     * Creates a customer in the database.
     * @param cus
     * @return ID of the new customer.
     * @throws Exception
     */
    @Override
    public int createCustomer(Customer cus) throws Exception {
        String sql = "INSERT INTO dbo.tblCustomers VALUES (?, ?, ?, ?)";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cus.getName());
        pstmt.setString(2, cus.getCprNum());
        pstmt.setString(3, cus.getPhoneNum());
        pstmt.setString(4, cus.getEmail());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Failed to add the customer.");
        }

        sql = "SELECT fldCustomerID FROM dbo.tblCustomers WHERE fldName = ? AND fldCprNum = ? AND fldPhoneNum = ? AND fldEmail = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cus.getName());
        pstmt.setString(2, cus.getCprNum());
        pstmt.setString(3, cus.getPhoneNum());
        pstmt.setString(4, cus.getEmail());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next())
        {
            return rs.getInt(1);
        }
        else
        {
            return 1;
        }
    }

    /**
     * Reads customer from the database by ID.
     * @param id
     * @return boolean if the id represents an existing customer.
     * @throws Exception
     */
    @Override
    public boolean readCustomer(int id) throws Exception{
        String sql = "SELECT * FROM dbo.tblCustomers WHERE fldCustomerID = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(rs.getString(1)));
            customer.setName(rs.getString(2));
            customer.setCprNum(rs.getString(3));
            customer.setPhoneNum(rs.getString(4));
            customer.setEmail(rs.getString(5));

            System.out.printf("--- Customer [%d] ---\nName: %s\nPhone Number: %s\nEmail: %s",
                    customer.getId(), customer.getName(), customer.getPhoneNum(), customer.getEmail());

            return true;
        } else {
            System.out.println("No customers found with ID: " + id);
            return false;
        }
    }

    /**
     * Reads all customers from the database.
     * @throws Exception
     */
    @Override
    public void readAllCustomers() throws Exception{
        String sql = "SELECT * FROM dbo.tblCustomers";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        System.out.println("--- All customers ---");
        System.out.println("ID, Name, PhoneNum, Email");

        boolean hasCustomer = false;
        while (rs.next()) {
            hasCustomer = true;
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(rs.getString(1)));
            customer.setName(rs.getString(2));
            customer.setCprNum(rs.getString(3));
            customer.setPhoneNum(rs.getString(4));
            customer.setEmail(rs.getString(5));

            System.out.printf("[%d] %s, %s, %s\n", customer.getId(), customer.getName(), customer.getPhoneNum(), customer.getEmail());
        }
        if (!hasCustomer) {
            System.out.println("No dogs found.");
        }
    }
}


