package Missions;
import Commands.*;


public class Mission1 extends Mission {
    String[] droneCommand = { Command.getCommand(), TakeOff.getCommand(),Flip.getCommand()};

   public Mission1(){
        Mission.sendCommand(droneCommand);
    }

    @Override
   public void selectMessages(){}

}