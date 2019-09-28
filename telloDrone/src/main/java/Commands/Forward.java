package Commands;

public class Forward implements TelloCommand {
    protected String command;

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
