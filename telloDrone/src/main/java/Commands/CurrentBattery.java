package Commands;

public class CurrentBattery implements TelloCommand {

    public static String getCommand() {
    return TelloCommandValues.CurrentBattery;
    }
}
