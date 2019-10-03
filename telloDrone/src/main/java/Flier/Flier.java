package Flier;
import Common.Communicator;

public class Flier{

Communicator communicator;

    public Flier(){}

    public Flier(Communicator communicator){
    this.communicator = communicator;
        }

        public void sendToCommunicator(String[] droneCommand)throws Exception{
            for(int i=0;i<droneCommand.length;i++){
            String droneMessage= droneCommand[i];
            communicator.sendCommand(droneMessage);
            String response= communicator.receiveData();
            System.out.println(response);
            }
        }
    }