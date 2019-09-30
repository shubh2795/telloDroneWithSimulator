import DroneWorld.Communicator;
import DroneWorld.DroneState;

import java.net.DatagramSocket;
import java.net.InetAddress;


public class Simulator {

    static DroneState droneState = new DroneState();
    String receivedCommand;
    int port;
    InetAddress address;

        public static void main(String[] args) throws Exception {
        // Step 1 : Create a socket to listen at port 8889
        DatagramSocket UdpServer = new DatagramSocket(8889);
        //Use communicators send and recv methods to communicate
        Communicator communicator = new Communicator(UdpServer);
        String receivedData;
        while (true) {
            receivedData = null;
            receivedData = communicator.receiveData();
            System.out.println(receivedData);
            System.out.println("in simulator");
            System.out.println(receivedData);

            Validator validator = new Validator(receivedData);
            System.out.println("2");

            boolean isValid = validator.validateCommands();
            if (isValid == false) {
                System.out.println("3");
                communicator.sendCommand("error");
            } else {
                System.out.println("4");
                validator.validateSequence(droneState,communicator);

            }
            System.out.println("5");
        }
    }


}
