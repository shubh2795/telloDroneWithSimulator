package Missions;
import DroneWorld.Communicator;

public class Mission3 implements Mission {

    String droneMessage;
    @Override
    public void sendCommand(Communicator communicator) throws Exception{
                String[] droneCommand = { "command", "takeoff", "back 25", "forward 25", "land" };

        for (int i = 0; i < droneCommand.length; i++) {
            droneMessage = droneCommand[i];
            communicator.sendCommand(droneMessage);
            String response= communicator.receiveData();
            System.out.println(response);
        }
    }
}
