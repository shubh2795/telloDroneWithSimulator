package Missions;
import Commands.*;
import Flier.Flier;


public abstract class Mission {


    public void sendCommand(Flier flier) throws Exception{

        String[] droneCommand = { Command.getCommand()};
        flier.fly(droneCommand);
    }

    public void sendTakeOff(Flier flier) throws Exception{
       String[] droneCommand = { TakeOff.getCommand()};
        flier.fly(droneCommand);
    }

    public void sendLand(Flier flier) throws Exception{

        String[] droneCommand = {  Land.getCommand() };
        flier.fly(droneCommand);
    }

    public void sendOtherCommands(Flier flier)throws Exception{}

    public final void executeMission(Flier flier)throws Exception{
        //Defining Skeleton
        sendCommand(flier);
        sendTakeOff(flier);
        sendOtherCommands(flier);
        sendLand(flier);
    }

}
