package MikkelGaming;

import java.sql.*;

public class FeedingDaoImpl implements FeedingDaoInterface {

    @Override
    public void readFoodTypes() throws Exception
    {
        String sql = "SELECT * FROM dbo.tblFoodTypes";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        System.out.println("--- Food Types ---");
        System.out.println("[ID] Name, Price, Description");

        if (rs.next()) {

            int id = rs.getInt(1);
            String name = rs.getString(2);
            int price = rs.getInt(3);
            String description = rs.getString(4);

            System.out.printf("[%d] %s, %d, %s\n", id, name, price, description);
        }
        else
        {
            System.out.println("No food types found.");
        }
    }

    @Override
    public boolean readSchedule(int id) throws Exception {
        String sql = "SELECT * FROM dbo.tblFeeding WHERE fldFeedingID = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            FeedingSchedule feedingSchedule = new FeedingSchedule();
            feedingSchedule.setId(Integer.parseInt(rs.getString(1)));
            feedingSchedule.setFrequency(Integer.parseInt(rs.getString(2)));
            feedingSchedule.setFoodType(rs.getInt(3));
            feedingSchedule.setAmount(rs.getInt(4));

            System.out.printf("-- Schedule -- \nID: [%d] \nFrequency: %d\nFoodType: %d\nAmount: %d\n",
                    feedingSchedule.getId(), feedingSchedule.getFrequency(), feedingSchedule.getFoodType(), feedingSchedule.getAmount());

            return true;
        } else {
            System.out.println("No Schedule found with ID: " + id);
            return false;
        }
    }

    @Override
    public String printSchedule(int id) throws Exception {
        String sql = "SELECT * FROM dbo.tblFeeding WHERE fldFeedingID = ?";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            FeedingSchedule feedingSchedule = new FeedingSchedule();
            feedingSchedule.setId(Integer.parseInt(rs.getString(1)));
            feedingSchedule.setFrequency(Integer.parseInt(rs.getString(2)));
            feedingSchedule.setFoodType(rs.getInt(3));
            feedingSchedule.setAmount(rs.getInt(4));

            return String.format("[%d] \nFrequency: %d\nFoodType: %d\nAmount: %d",
                    feedingSchedule.getId(), feedingSchedule.getFrequency(), feedingSchedule.getFoodType(), feedingSchedule.getAmount());
        } else {
            System.out.println("No Schedule found with ID: " + id);
            return "None";
        }
    }

    @Override
    public void readAllSchedules() throws Exception {
        String sql = "SELECT * FROM dbo.tblFeeding";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasSchedule = false;
        while (rs.next()) {
            hasSchedule = true;
            Dog dog = new Dog();
            dog.setId(Integer.parseInt(rs.getString(1)));
            dog.setName(rs.getString(2));
            dog.setCustomerID(Integer.parseInt(rs.getString(3)));
            System.out.println(dog.getId()+" "+ dog.getName()+dog.getCustomerID());
        }
        if (!hasSchedule) {
            System.out.println("No schedules found.");
        }
    }

    @Override
    public int createSchedule(FeedingSchedule schedule) throws Exception
    {
        String sql = "INSERT INTO dbo.tblFeeding VALUES (?, ?, ?)";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, schedule.getFrequency());
        pstmt.setInt(2, schedule.getFoodType());
        pstmt.setInt(3, schedule.getAmount());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Feeding schedule added successfully.");
        } else {
            System.out.println("Failed to add the feeding schedule.");
        }
        sql = "SELECT fldFeedingID FROM dbo.tblFeeding WHERE fldFrequency = ? AND fldFoodType = ? AND fldAmount = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, schedule.getFrequency());
        pstmt.setInt(2, schedule.getFoodType());
        pstmt.setInt(3, schedule.getAmount());
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

}
