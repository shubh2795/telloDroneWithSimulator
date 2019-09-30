package Missions;
import Commands.*;
import DroneWorld.Communicator;

public class Mission3 implements Mission {

    String droneMessage;
    @Override
    public void sendCommand(Communicator communicator) throws Exception{
    String[] droneCommand = { Command.getCommand(), TakeOff.getCommand(),Right.getCommand() ,Cw.getCommand(),Ccw.getCommand(),Left.getCommand() ,Land.getCommand() };

        for (int i = 0; i < droneCommand.length; i++) {
            droneMessage = droneCommand[i];
            communicator.sendCommand(droneMessage);
           String response= communicator.receiveData();
            System.out.println(response);
        }
    }
}
