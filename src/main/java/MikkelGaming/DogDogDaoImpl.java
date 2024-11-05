package MikkelGaming;

import java.sql.*;

public class DogDogDaoImpl implements DogDaoInterface {

    @Override
    public void createFeedingSchedule(FeedingSchedule fs) throws Exception
    {
        String sql = "INSERT INTO dbo.tblFeeding VALUES (?, ?, ?)";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, fs.getFrequency());
        pstmt.setInt(2, fs.getFoodType());
        pstmt.setInt(3, fs.getAmount());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Feeding schedule added successfully.");
        } else {
            System.out.println("Failed to add the feeding schedule.");
        }
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
        Connection conn = Main.getConnection();
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
        Connection conn = Main.getConnection();
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


