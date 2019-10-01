package Flier;

import Common.Communicator;
import Common.DroneState;
import Common.Status;

import java.net.DatagramSocket;

public class FlierStatusThread  extends Thread {

    public static DroneState droneState = new DroneState();
    Communicator statusCommunicator;

        public FlierStatusThread() throws  Exception {
            DatagramSocket flierSocket= new DatagramSocket(8890);
            statusCommunicator =  new Communicator(flierSocket);
        }

        public void run(){
            System.out.println("Thread for refreshing drone state every 100ms ");
            //drone state method

            while(true){
                String receivedStatus =  null;
                try {
                    receivedStatus=statusCommunicator.receiveData();
                    Status status = new Status(receivedStatus);
                    droneState.updateFlyingInfo(status);
                    Thread.sleep(100);
                }   catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


}
