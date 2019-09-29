package Missions;
import Commands.*;


public class Mission2 extends Mission {
    String[] droneCommand = { Command.getCommand(), TakeOff.getCommand(), Flip.getCommand(), Left.getCommand(), Land.getCommand() };


    @Override
    public void selectMessages(){}
    public Mission2 (){
        Mission.sendCommand(droneCommand);
    }
}
