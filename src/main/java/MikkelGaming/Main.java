package MikkelGaming;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=LAPTOP-R56SEDRE\\MSSQLSERVER01;portNumber=1433;databaseName=dbRosasHundepension";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "entotrefirefemseks"; // replace with your password
    private static Connection conn;

    public static Connection getConnection() throws Exception {
        if (conn == null) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        }

        return conn;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("start");
        conn = getConnection();

        System.out.println("Welcome to the dog pension system");
        Menus.mainMenu();

        System.out.println("slut");
    }
}