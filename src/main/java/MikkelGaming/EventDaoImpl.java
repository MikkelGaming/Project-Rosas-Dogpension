package MikkelGaming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EventDaoImpl implements EventDaoInterface{

    /**
     * Prints all logs from the database.
     * @throws Exception
     */
    @Override
    public void showAllLogs() throws Exception {
        String sql = "SELECT * FROM dbo.tblEvents";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("--- All events ---");
        System.out.println("[ID] Description, Event type, DogID");
        boolean hasEvents = false;
        while (rs.next()) {
            hasEvents = true;

            System.out.printf("[%d] %s, %d, %d\n", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
        }
        if (!hasEvents) {
            System.out.println("No events found.");
        }
    }

    /**
     * Prints the event types from the database.
     * @throws Exception
     */
    @Override
    public void showAllEventTypes() throws Exception {
        String sql = "SELECT * FROM dbo.tblEventTypes";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("--- All event types ---");
        System.out.println("[ID] Name");
        boolean hasEvents = false;
        while (rs.next()) {
            hasEvents = true;

            System.out.printf("[%d] %s\n", rs.getInt(1), rs.getString(2));
        }
        if (!hasEvents) {
            System.out.println("No event types found.");
        }
    }

    /**
     * Creates a new event/log in the database.
     * @param event the new event/log
     * @throws Exception
     */
    @Override
    public void createEvent(DogEvent event) throws Exception {
        String sql = "INSERT INTO dbo.tblEvents VALUES (?, ?, ?)";
        Connection conn = Main.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, event.getDescription());
        pstmt.setInt(2, event.getEventType());
        pstmt.setInt(3, event.getDogID());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Event/log added successfully.");
        } else {
            System.out.println("Failed to add the event/log.");
        }
    }
}
