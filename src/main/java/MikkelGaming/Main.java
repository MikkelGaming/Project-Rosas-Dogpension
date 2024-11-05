package MikkelGaming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.InputMismatchException;
import java.util.Scanner;
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

    public static void main(String args []) throws Exception{
        System.out.println("start");
        conn = getConnection();

        DogDaoInterface dao = new DogDogDaoImpl();

        dao.readAllDogs();

        //Customer cus = new Customer("Karl", "2222221234", "22121010", "Karl@communism.net");
        //dao.createCustomer(cus);
        Dog d = new Dog();
        d.setName("Gary");
        d.setCustomerID(1);
        d.setBirthday(new Date(2012,7,22));
        d.setInsurance("Many");
        d.setExpectedStay(250);
        d.setFeedingID(1);
        d.setFleaTreatment("Yes");
        d.setPreferredVetID(1);
        d.setRace("Labrador");
        d.setSpecialRequirements("none");
        d.setVaccines("All of them");
        d.setWeight(25);
        //dao.createDog(d);

        dao.readAllDogs();

        System.out.println("slut");
    }
}