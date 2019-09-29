package Commands;

import java.util.Scanner;

public class Back implements TelloCommand {
    public static String getCommand() {
        System.out.println("Enter the distance to move upwards x= 20-500");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        while ( x<20 || x>500 ){
            System.out.println("Distance out of drone range. Please re-enter");
            x = scanner.nextInt();
        }
       return TelloCommandValues.Back + " "+ x;
    }
}
