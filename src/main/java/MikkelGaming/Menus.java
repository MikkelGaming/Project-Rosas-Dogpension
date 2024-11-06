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
        System.out.println("4. Exit");
        switch (Input.safeInt())
        {
            case 1:
                System.out.println("Which dog action would you like to do?");
                dogActions();
                break;

            case 2:
                System.out.println("Which dog event would you like to log?");
                eventLogActions();
                break;

            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option");
                System.out.println("Please select an valid option:");
                mainMenuOptions();
                break;
        }

        mainMenu();
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
                System.out.println("Input the following details to create a new dog: ");
                createDogMenu();
                break;

            case 2:
                System.out.println("Please select one of the following options: ");
                showDogMenu();
                break;

            case 3:
                System.out.println("Please enter the new details for the dog: ");
                updateDogMenu();
                break;

            case 4:
                deleteDogMenu();
                break;

            case 5:
                mainMenu();
                break;

            default:
                System.out.println("Invalid option");
                System.out.println("Please select an valid option:");
                dogActions();
                break;
        }
    }

    private static void deleteDogMenu() throws Exception
    {
        DogDaoInterface dao = new DogDogDaoImpl();
        dao.readAllDogsIdOnly();
        System.out.println("Enter the ID of the dog you want to delete");
        dao.deleteDog(Input.safeInt());
    }

    private static void updateDogMenu() throws Exception
    {
        DogDaoInterface dogDao = new DogDogDaoImpl();
        VetDaoInterface vetDao = new VetDaoImpl();
        Dog d = new Dog();

        dogDao.readAllDogsIdOnly();

        System.out.println("Enter the id of the dog you want to update: ");
        d.setName(Input.string());

        System.out.println("Enter the name of the dog: ");
        d.setName(Input.string());

        System.out.println("Enter the id of the dog owner");
        System.out.println("[0] To create a new customer");
        d.setCustomerID(inputCustomerID());

        System.out.println("--- Enter the birthday of the dog---");
        d.setBirthday(inputBirthday());

        System.out.println("Enter Insurance type (short max 60 characters): ");
        String insurance = Input.string();
        if (insurance.length() > 60)
        {
            insurance = insurance.substring(0, 59);
        }
        d.setInsurance(insurance);

        System.out.println("Enter the expected stay in hours");
        d.setExpectedStay(Input.safeInt());

        System.out.println("Enter the ID of the feeding schedule: ");
        System.out.println("[0] To create a new schedule");
        d.setFeedingID(inputScheduleID());

        System.out.println("Enter flea treatment details (short max 60 characters): ");
        String treatment = Input.string();
        if (treatment.length() > 60)
        {
            treatment = treatment.substring(0, 59);
        }
        d.setFleaTreatment(treatment);

        System.out.println("Enter preferred vet from the list: ");
        vetDao.readAllVets();
        d.setPreferredVetID(Input.safeInt());

        System.out.println("Enter the race of the dog (max 50 characters):");
        String race = Input.string();
        if (race.length() > 50)
        {
            race = race.substring(0, 49);
        }
        d.setRace(race);

        System.out.println("Enter special requirements if any (max 240 characters):");
        String requirements = Input.string();
        if (requirements.length() > 50)
        {
            requirements = requirements.substring(0, 49);
        }
        d.setSpecialRequirements(requirements);

        System.out.println("Enter vaccine details (max 60 characters):");
        String vaccines = Input.string();
        if (vaccines.length() > 60)
        {
            vaccines = vaccines.substring(0, 59);
        }
        d.setVaccines(vaccines);

        System.out.println("Enter the weight of the dog: ");
        d.setWeight(Input.safeInt());

        dogDao.updateDog(d);
    }

    private static void createDogMenu() throws Exception
    {
        DogDaoInterface dogDao = new DogDogDaoImpl();
        VetDaoInterface vetDao = new VetDaoImpl();
        Dog d = new Dog();

        System.out.println("Enter the name of the dog: ");
        d.setName(Input.string());

        System.out.println("Enter the id of the dog owner");
        System.out.println("[0] To create a new customer");
        d.setCustomerID(inputCustomerID());

        System.out.println("--- Enter the birthday of the dog---");
        d.setBirthday(inputBirthday());

        System.out.println("Enter Insurance type (short max 60 characters): ");
        String insurance = Input.string();
        if (insurance.length() > 60)
        {
            insurance = insurance.substring(0, 59);
        }
        d.setInsurance(insurance);

        System.out.println("Enter the expected stay in hours");
        d.setExpectedStay(Input.safeInt());

        System.out.println("Enter the ID of the feeding schedule: ");
        System.out.println("[0] To create a new schedule");
        d.setFeedingID(inputScheduleID());

        System.out.println("Enter flea treatment details (short max 60 characters): ");
        String treatment = Input.string();
        if (treatment.length() > 60)
        {
            treatment = treatment.substring(0, 59);
        }
        d.setFleaTreatment(treatment);

        System.out.println("Enter preferred vet from the list: ");
        vetDao.readAllVets();
        d.setPreferredVetID(Input.safeInt());

        System.out.println("Enter the race of the dog (max 50 characters):");
        String race = Input.string();
        if (race.length() > 50)
        {
            race = race.substring(0, 49);
        }
        d.setRace(race);

        System.out.println("Enter special requirements if any (max 240 characters):");
        String requirements = Input.string();
        if (requirements.length() > 50)
        {
            requirements = requirements.substring(0, 49);
        }
        d.setSpecialRequirements(requirements);

        System.out.println("Enter vaccine details (max 60 characters):");
        String vaccines = Input.string();
        if (vaccines.length() > 60)
        {
            vaccines = vaccines.substring(0, 59);
        }
        d.setVaccines(vaccines);

        System.out.println("Enter the weight of the dog: ");
        d.setWeight(Input.safeInt());

        dogDao.createDog(d);
    }

    private static int inputCustomerID() throws Exception
    {
        CustomerDaoInterface dao = new CustomerDaoImpl();

        int inputID = Input.safeInt();
        if (inputID == 0)
        {
            inputID = createCustomer();
        }
        else
        {
            if (!dao.readCustomer(inputID))
            {
                System.out.println("Customer does not exist");
                System.out.println("Please enter a valid customer ID or create a new customer");
                return inputCustomerID();
            }
        }
        return inputID;
    }

    private static Date inputBirthday()
    {
        Date date;
        System.out.println("Enter year of birth");
        int birthYear = Input.safeInt();

        System.out.println("Enter month of birth");
        int birthMonth = Input.safeInt();

        System.out.println("Enter day of birth");
        int birthDay = Input.safeInt();

        try {
            date = Date.valueOf(birthYear + "-" + birthMonth + "-" + birthDay);

        }
        catch (Exception e)
        {
            System.out.println("Incorrect date input try again.");
            date = inputBirthday();
        }
        return date;
    }

    private static int inputScheduleID() throws Exception
    {
        FeedingDaoInterface dao = new FeedingDaoImpl();

        int inputID = Input.safeInt();
        if (inputID == 0)
        {
            inputID = createSchedule();
        }
        else
        {
            if (!dao.readSchedule(inputID))
            {
                System.out.println("Schedule does not exist");
                System.out.println("Please enter a valid schedule ID or create a new schedule");
                return inputScheduleID();
            }
        }

        return inputID;
    }

    private static int createSchedule() throws Exception
    {
        FeedingDaoInterface dao = new FeedingDaoImpl();
        FeedingSchedule schedule = new FeedingSchedule();

        System.out.println("Enter the feeding frequency (Feeding per day): ");
        schedule.setFrequency(Input.safeInt());

        System.out.println("Enter the Food Type by ID: ");
        dao.readFoodTypes();

        int inputID = Input.safeInt();
        if (inputID >= 1 && inputID <= 5)
        {
            schedule.setFoodType(inputID);
        }
        else
        {
            System.out.println("Incorrect input food type set to 1.");
            schedule.setFoodType(1);
        }

        System.out.println("Enter the amount of food to give: ");
        schedule.setAmount(Input.safeInt());

        return  dao.createSchedule(schedule);
    }

    private static void showDogMenu() throws Exception
    {
        System.out.println("1. Show all dogs");
        System.out.println("2. Show specific dog");
        System.out.println("3. Exit");
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

            case 3:
                mainMenu();
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
        System.out.println("1. Create log");
        System.out.println("2. Show all logs");
        System.out.println("3. Exit");
        switch (Input.safeInt())
        {
            case 1:

                break;

            case 2:

                break;

            case 3:

                break;
        }
    }

    private static int createCustomer() throws Exception
    {
        CustomerDaoInterface dao = new CustomerDaoImpl();
        Customer customer = new Customer();

        System.out.println("Enter the name of the customer: ");
        customer.setName(Input.string());

        System.out.println("Enter the cpr number of the customer: ");
        customer.setCprNum(Input.string());

        System.out.println("Enter the phone number of the customer: ");
        String phoneNum = Input.string();
        if (phoneNum.length() > 14)
        {
            phoneNum = phoneNum.substring(0, 13);
        }
        customer.setPhoneNum(phoneNum);

        System.out.println("Enter the email address of the customer: ");
        customer.setEmail(Input.string());

        return dao.createCustomer(customer);
    }
}
