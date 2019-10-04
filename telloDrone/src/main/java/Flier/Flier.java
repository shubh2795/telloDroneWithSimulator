package Flier;
import Common.Communicator;
import Common.SendAndReceive;

public class Flier {

    Communicator communicator;

    public Flier() {
    }

    public Flier(Communicator communicator) {
        this.communicator = communicator;
    }

    public void sendToCommunicator(String[] droneCommand) throws Exception {

        for (int i = 0; i < droneCommand.length; i++) {
            String droneMessage = droneCommand[i];
            SendAndReceive.sendAndReceive(droneMessage,communicator);
        }
    }
}
