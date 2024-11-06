package MikkelGaming;

import java.util.Scanner;

public class Input {

    public static String string()
    {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

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

    public static void enterToContinue()
    {
        System.out.println("Press Enter to continue");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
