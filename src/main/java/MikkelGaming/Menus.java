package MikkelGaming;

import java.sql.Date;

public class Menus {

    /**
     * Starts the main menu options
     * @throws Exception
     */
    public static void mainMenu() throws Exception
    {
        System.out.println("Please select an option:");
        mainMenuOptions();
    }

    /**
     * The main menu options, shows options and takes input for what the user wants to do.
     * @throws Exception
     */
    private static void mainMenuOptions() throws Exception
    {
        System.out.println("1. Dog actions");
        System.out.println("2. Dog Event/Log actions");
        System.out.println("3. Print Information card");
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

            case 3:
                printInfoCard();
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

    /**
     * Prints the info required by the infocard.
     * @throws Exception
     */
    private static void printInfoCard() throws Exception
    {
        DogDaoInterface dao = new DogDogDaoImpl();

        System.out.println("Enter the ID of the dog: ");
        dao.printInfoCard(Input.safeInt());

        Input.enterToContinue();
    }

    /**
     * Allows the user all CRUD actions.
     * Customers and Schedules are also created here.
     * @throws Exception
     */
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

    /**
     * Deletes the dog with the ID that is entered.
     * @throws Exception
     */
    private static void deleteDogMenu() throws Exception
    {
        DogDaoInterface dao = new DogDogDaoImpl();
        dao.readAllDogsIdOnly();
        System.out.println("Enter the ID of the dog you want to delete");
        dao.deleteDog(Input.safeInt());
    }

    /**
     * Allows the User to update the variables of a dog.
     * Also allows the creation of a new customer or schedule.
     * @throws Exception
     */
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

    /**
     * Handles the creation of new dogs, customers and schedules.
     * @throws Exception
     */
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

    /**
     * Checks if the ID provided by the user is the ID of an existing Customer.
     * If not it allows the creation of a new customer.
     * @return the id of a existing customer or a new one.
     * @throws Exception
     */
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

    /**
     * Checks the input of the user for the dog ID.
     * if it does not yet exist it allows for new input or creating a new dog.
     * @return ID of an existing dog or the newly created one.
     * @throws Exception
     */
    private static int inputDogID() throws Exception
    {
        DogDaoInterface dogDao = new DogDogDaoImpl();
        dogDao.readAllDogsIdOnly();

        int inputID = Input.safeInt();

        if (inputID == 0)
        {
            mainMenu();
        }

        if (!dogDao.readDog(inputID, false))
        {
            System.out.println("Dog does not exist");
            System.out.println("Please enter a valid dog ID or enter 0 to exit.");
            return inputDogID();
        }

        return inputID;
    }

    /**
     * Checks the Input for the dog birthday.
     * Makes sure it is a correct date/format.
     * @return Date in correct format.
     */
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

    /**
     * Checks for correct schedule ID input.
     * If input is an incorrect schedule ID it allows for another input or the creation of a new schedule.
     * @return int ID of existing schedule.
     * @throws Exception
     */
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

    /**
     * Handles of the creation of schedule.
     * @return int ID of the new schedule.
     * @throws Exception
     */
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

    /**
     * Handles the Dog actions menu.
     * @throws Exception
     */
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
                dao.readDog(Input.safeInt(), true);
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

    /**
     * Handles the menu for logging actions.
     * @throws Exception
     */
    private static void eventLogActions() throws Exception
    {
        System.out.println("1. Create log");
        System.out.println("2. Show all logs");
        System.out.println("3. Exit");
        switch (Input.safeInt())
        {
            case 1:
                createLog();
                break;

            case 2:
                showAllLogs();
                break;

            case 3:
                mainMenu();
                break;
        }
        Input.enterToContinue();
        mainMenu();
    }

    /**
     * Handles creation of a new log.
     * @throws Exception
     */
    private static void createLog() throws Exception
    {
        DogEvent event = new DogEvent();
        EventDaoInterface dao = new EventDaoImpl();

        System.out.println("What type of event are you logging: ");
        dao.showAllEventTypes();

        int eventType = Input.safeInt();
        if (eventType >= 1 && eventType <= 5)
        {
            event.setEventType(eventType);
        }
        else {
            System.out.println("Incorrect event type, setting type to 1.");
            event.setEventType(1);
        }

        System.out.println("Describe the event (480 characters): ");
        String desc = Input.string();
        if (desc.length() > 480)
        {
            desc = desc.substring(0, 479);
        }
        event.setDescription(desc);

        System.out.println("What dog is the event about (ID): ");
        event.setDogID(inputDogID());

        dao.createEvent(event);
    }

    /**
     * Shows all existing logs.
     * @throws Exception
     */
    private static void showAllLogs() throws Exception
    {
        EventDaoInterface dao = new EventDaoImpl();

        dao.showAllEventTypes();

        dao.showAllLogs();
    }

    /**
     * Handles the creation of a new customer.
     * @return int ID of newly created customer.
     * @throws Exception
     */
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
