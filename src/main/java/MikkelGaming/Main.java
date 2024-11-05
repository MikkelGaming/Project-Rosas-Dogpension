package MikkelGaming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

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


    public static void main(String args []) throws Exception{
        System.out.println("start");
        Connection conn = getConnection();

        DaoInterface dao = new DaoImpl();

        dao.readAllDogs();

        //Customer cus = new Customer("Karl", "2222221234", "22121010", "Karl@communism.net");
        //dao.createCustomer(cus);
        Dog d = new Dog();
        d.setName("Gary");
        d.setCustomerID(1);
        d.setBirthday(new Date(2012,7,22));

        dao.createDog(d);

        dao.readAllDogs();

        System.out.println("slut");
    }

    private static int safeIntInput()
    {
        int a = 0;
        try {
            a = sc.nextInt();
            sc.nextLine();
        }
        catch (Exception e)
        {
            if (e instanceof InputMismatchException)
            {
                System.out.println("Syntax error: You did not enter a number");
                System.out.println("Try again: ");
                sc.nextLine();
                a = safeIntInput();
            }
        }
        return a;
    }
}