package Commands;
import java.util.Scanner;
public class Ccw implements TelloCommand {



    public static String getCommand() {
        System.out.println("Enter the Degrees for rotation x= 0 -360");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Ccw).append(" ").append(x).toString();

        return NewCommand;
    }
}
