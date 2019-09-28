package Commands;

public class Sdk implements TelloCommand {
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
