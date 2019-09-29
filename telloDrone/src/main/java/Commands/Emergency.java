package Commands;

public class Emergency implements TelloCommand {
    public static String getCommand() {

        return TelloCommandValues.Emergency;
    }
}
