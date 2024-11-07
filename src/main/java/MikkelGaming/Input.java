package MikkelGaming;

import java.util.Scanner;

public class Input {

    /**
     * Allows users to input a string.
     * @return input
     */
    public static String string()
    {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Allows users to input a int, checks if it is a valid int.
     * @return int input.
     */
    public static int safeInt()
    {
        Scanner sc = new Scanner(System.in);
        int safeInput;
        try {
            safeInput = sc.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Please enter an integer");
            return safeInt();
        }
        return safeInput;
    }

    /**
     * Stops the program until the user has pressed enter.
     */
    public static void enterToContinue()
    {
        System.out.println("Press Enter to continue");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
