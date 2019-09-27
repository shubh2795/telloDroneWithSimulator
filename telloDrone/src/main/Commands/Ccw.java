package Users.shubh.IdeaProjects.Homework2.telloDrone.src.main.Commands;

public class Ccw implements TelloCommand {
    protected String command;

    public composeCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
