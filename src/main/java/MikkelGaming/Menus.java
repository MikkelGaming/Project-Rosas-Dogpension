package MikkelGaming;

public class Menus {
    public void MainMenu()
    {
        System.out.println("Welcome to the dog pension system");
        System.out.println("Please select an option:");
        MainMenuOptions();
    }

    public void MainMenuOptions()
    {
        System.out.println("1. Dog actions");
        System.out.println("2. Customer actions");
        System.out.println("3. Exit");
        switch (Input.safeInt())
        {
            case 1:
                DogActions();
                break;

            default:
                System.out.println("Invalid option");
                System.out.println("Please select an valid option:");
                MainMenuOptions();
                break;
        }
    }

    public void DogActions()
    {
        System.out.println("Which dog action would you like to do?");
        System.out.println("1. Create Dog");
        System.out.println("2. Show Dog");
        System.out.println("3. Update Dog");
        System.out.println("4. Delete Dog");
        System.out.println("5. Create Dog Event/Log");
        System.out.println("6. Show Dog Event/Log");
        System.out.println("7. Exit");
        switch (Input.safeInt())
        {
            case 1:
        }
    }
}
