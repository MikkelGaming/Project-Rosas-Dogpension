package MikkelGaming;

import java.sql.*;

public class DaoImpl implements DaoInterface {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=LAPTOP-R56SEDRE\\MSSQLSERVER01;portNumber=1433;databaseName=dbRosasHundepension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "entotrefirefemseks"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    @Override
    public void createDog(Dog dog) throws Exception {
        String sql = "INSERT INTO dbo.tblDogs VALUES (?, ?, ?)";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dog.getName());
        pstmt.setInt(2, dog.getCustomerID());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    @Override
    public void readDog(int id) throws Exception{
        String sql = "SELECT * FROM dbo.tblDogs WHERE fldDogID = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setCustomerID(Integer.parseInt(rs.getString(3)));
            dog.setName(rs.getString(2));
            System.out.println(dog.getId() + " "+ dog.getName()+ " "+ dog.getCustomerID());
        } else {
            System.out.println("No Dog found with ID: " + id);
        }
    }

    @Override
    public void readAllDogs() throws Exception{
        String sql = "SELECT * FROM dbo.tblDogs";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDepartments = false;
        while (rs.next()) {
            hasDepartments = true;
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setName(rs.getString(2));
            dog.setCustomerID(Integer.parseInt(rs.getString(3)));
            System.out.println(dog.getId()+" "+ dog.getName()+dog.getCustomerID());
        }
        if (!hasDepartments) {
            System.out.println("No dogs found.");
        }
    }

    @Override
    public void createCustomer(Customer cus) throws Exception {
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
    }

    @Override
    public void readCustomer(int id) throws Exception{
        String sql = "SELECT * FROM dbo.tblCustomers WHERE fldCustomerID = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setCustomerID(Integer.parseInt(rs.getString(3)));
            dog.setName(rs.getString(2));
            System.out.println(dog.getId() + " "+ dog.getName()+ " "+ dog.getCustomerID());
        } else {
            System.out.println("No customers found with ID: " + id);
        }
    }

    @Override
    public void readAllCustomers() throws Exception{
        String sql = "SELECT * FROM dbo.tblCustomers";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDepartments = false;
        while (rs.next()) {
            hasDepartments = true;
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setName(rs.getString(2));
            dog.setCustomerID(Integer.parseInt(rs.getString(3)));
            System.out.println(dog.getId()+" "+ dog.getName()+dog.getCustomerID());
        }
        if (!hasDepartments) {
            System.out.println("No dogs found.");
        }
    }
}


