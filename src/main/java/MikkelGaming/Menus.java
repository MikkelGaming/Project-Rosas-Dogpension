package MikkelGaming;

import java.sql.Date;

public class Menus {

    public static void mainMenu() throws Exception
    {
        System.out.println("Please select an option:");
        mainMenuOptions();
    }

    private static void mainMenuOptions() throws Exception
    {
        System.out.println("1. Dog actions");
        System.out.println("2. Dog Event/Log actions");
        System.out.println("3. Feeding Schedule actions");
        System.out.println("4. Customer actions");
        System.out.println("5. Exit");
        switch (Input.safeInt())
        {
            case 1:
                System.out.println("Which dog action would you like to do?");
                dogActions();
                break;

            case 2:
                System.out.println("Which dog event would you like to log?");

                break;

            case 3:
                System.out.println("Which feeding schedule action would you like to take?");
                break;

            case 4:
                System.out.println("Which customer action would you like to do?");
                customerActions();
                break;

            default:
                System.out.println("Invalid option");
                System.out.println("Please select an valid option:");
                mainMenuOptions();
                break;
        }
    }

    private static void dogActions() throws Exception
    {
        System.out.println("1. Create Dog");
        System.out.println("2. Show Dog");
        System.out.println("3. Update Dog");
        System.out.println("4. Delete Dog");
        System.out.println("5. Exit");
        switch (Input.safeInt())
        {
            case 1:

                break;

            case 2:
                System.out.println("Please select one of the following options: ");
                showDogMenu();
                break;

            case 3:

                break;

            default:
                System.out.println("Invalid option");
                System.out.println("Please select an valid option:");
                dogActions();
                break;
        }
    }

    private static void createDogMenu() throws Exception
    {
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
    }

    private static void showDogMenu() throws Exception
    {
        System.out.println("1. Show all dogs");
        System.out.println("2. Show specific dog");
        DogDaoInterface dao = new DogDogDaoImpl();
        switch (Input.safeInt())
        {
            case 1:
                dao.readAllDogs();
                break;

            case 2:
                System.out.println("Here is a list of all dogs with ID:");
                dao.readAllDogsIdOnly();
                dao.readDog(Input.safeInt());
                break;

            default:
                System.out.println("Invalid option");
                System.out.println("Please select an valid option:");
                showDogMenu();
                break;
        }
        Input.enterToContinue();
        mainMenu();
    }

    private static void eventLogActions()
    {

    }

    private static void customerActions()
    {

    }
}
