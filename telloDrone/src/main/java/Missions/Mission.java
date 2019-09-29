package Missions;
import DroneWorld.Communicator;


public abstract class Mission {

    abstract void selectMessages();

    //Concrete Method
    public static void sendCommand( String[] droneCommand ){
        Communicator communicator = new Communicator();


        for(int i=0;i<droneCommand.length;i++ ){
            try {
                communicator.sendCommand(droneCommand[i]);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }

}
