package Flier;

import Common.Communicator;
import Common.DroneState;
import Common.Status;

import java.net.DatagramSocket;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FlierStatusThread  extends Thread {

    private Logger logger;

    public static DroneState droneState = new DroneState();
    Communicator statusCommunicator;

        public FlierStatusThread() throws  Exception {
            DatagramSocket flierSocket= new DatagramSocket(8890);
            statusCommunicator =  new Communicator(flierSocket);
            logger=Logger.getLogger(FlierStatusThread.class.getName());
            FileHandler fileHandler = new FileHandler("C:/Users/shubh/IdeaProjects/HomeWork-2/src/main/java/LogFiles/logfile.txt");
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);
        }

        public void run(){
            System.out.println("Thread for refreshing drone state every 100ms ");
            //drone state method

            while(true){
                String receivedStatus =  null;
                try {
                    receivedStatus=statusCommunicator.receiveData();
                    logger.info(receivedStatus);
                    Status status = new Status(receivedStatus);
                    droneState.updateFlyingInfo(status);
                    Thread.sleep(100);
                }   catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


}
