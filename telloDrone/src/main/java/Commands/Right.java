package Commands;

import java.util.Scanner;

public class Right implements TelloCommand {
    public static String getCommand() {
        System.out.println("Enter the distance to move right x= 20-500");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Right).append(" ").append(x).toString();
         return NewCommand;
    }
}
