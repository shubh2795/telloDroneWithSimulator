package Missions;

import Commands.*;
import DroneWorld.*;

public class Mission1 implements Mission {
    String droneMessage;
    @Override
    public void sendCommand(Communicator communicator) throws Exception{
        String[] droneCommand = { Command.getCommand(), TakeOff.getCommand(),Land.getCommand() };

        for (int i = 0; i < droneCommand.length; i++) {
            droneMessage = droneCommand[i];
            communicator.sendCommand(droneMessage);
            //String response= communicator.receiveData();
            //System.out.println(response);

        }
    }
}