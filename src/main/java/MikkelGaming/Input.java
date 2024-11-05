package MikkelGaming;

import java.util.Scanner;

public class Input {

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
}
