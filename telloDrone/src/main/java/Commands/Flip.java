package Commands;

import java.util.Scanner;

public class Flip implements TelloCommand {
    protected String command;

    public static String getCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the the type of flip");
        String x = scanner.nextLine();
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Flip).append(" ").append(x).toString();
        return NewCommand;

    }
}
