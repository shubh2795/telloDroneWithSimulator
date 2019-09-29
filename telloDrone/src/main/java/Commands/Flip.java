package Commands;

public class Flip implements TelloCommand {
    protected String command;

    public static String getCommand() {

        return TelloCommandValues.Flip;
    }
}
