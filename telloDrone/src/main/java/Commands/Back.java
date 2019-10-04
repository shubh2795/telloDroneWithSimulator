package Commands;

import java.util.Scanner;

public class Back implements TelloCommand {
    public static String getCommand() {
        System.out.println("Enter the distance to move backwards x= 20-500");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Back).append(" ").append(x).toString();
        return NewCommand;    }
}
