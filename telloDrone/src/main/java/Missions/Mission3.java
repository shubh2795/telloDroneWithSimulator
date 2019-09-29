package Missions;
import Commands.*;


public class Mission3 extends Mission {
    String[] droneCommand = { Command.getCommand(), TakeOff.getCommand(), Cw.getCommand(), Right.getCommand(), Land.getCommand() };


    @Override
    public void selectMessages(){}

   public Mission3(){
        Mission.sendCommand(droneCommand);
    }
}
