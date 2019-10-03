package Missions;
import Commands.*;
import Flier.Flier;


public class Mission2 extends Mission {


    @Override
    public void sendOtherCommands(Flier flier) throws Exception{
        String[] droneCommand = { Forward.getCommand(),Back.getCommand(),Ccw.getCommand()};
        flier.sendToCommunicator(droneCommand);
    }
}
