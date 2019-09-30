import DroneWorld.Communicator;
import DroneWorld.DroneState;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Simulator {

    static DroneState droneState = new DroneState();
    String receivedCommand;
    int port;
    InetAddress address;

    public static final String reply = "ok";
    public static final String error = "Invalid Command";

    public static void main(String[] args) throws Exception {
        // Step 1 : Create a socket to listen at port 8889
        DatagramSocket UdpServer = new DatagramSocket(8889);
        //Use communicators send and recv methods to communicate
        Communicator communicator = new Communicator(UdpServer);
        String receivedData;
        receivedData=communicator.receiveData();
        System.out.println(receivedData);
        //TODO: Validation of port number and address
        int receivedPort = communicator.getDestinationPort();
        InetAddress receivedAddress =communicator.getDestinationAddress();

        Validation validator = new Validation(receivedData);
        validator.validateCommands(receivedPort,receivedAddress);


            boolean isValid=  validator.validateCommands(receivedPort,receivedAddress);
            if (isValid == false){
                communicator.sendCommand(error);
            }

            boolean sendReply= validator.validateSequence(droneState);


            if (sendReply == true){
                communicator.sendCommand(reply);
            }



        }
    }



