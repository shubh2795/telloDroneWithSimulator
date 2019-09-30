package Commands;

import java.util.Scanner;

public class Left implements TelloCommand {
    public static String getCommand() {
        System.out.println("Enter the distance to move left x= 20-500");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Left).append(" ").append(x).toString();

        return NewCommand;
    }
}
