package Commands;

public class Stop implements TelloCommand {
    protected String command;

    @Override
    public void composeCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
