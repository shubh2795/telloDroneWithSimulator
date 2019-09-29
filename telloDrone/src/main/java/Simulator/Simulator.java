package Simulator;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import DroneWorld.*;


public abstract class Simulator {

    static DroneState droneState = new DroneState();

    String receivedCommand;
    int port;
    InetAddress address;

    //Template method pattern
    abstract  boolean validateCommands(int port, InetAddress address)throws IOException ;
    abstract boolean validateSequence(DroneState droneState)throws Exception;

    public final void validate()throws Exception{
        // template
        validateCommands( port,  address);
        validateSequence(droneState);

    }

    public static final String reply = "ok";
    public static final String error = "Invalid Command";





    public static void main(String[] args) throws Exception {
        // Step 1 : Create a socket to listen at port 8889
        DatagramSocket UdpServer = new DatagramSocket(8889);
        Communicator communicator = new Communicator(UdpServer);
        String receivedData;
        receivedData=communicator.receiveData();
        int recievedPort = communicator.getDestinationPort();
        InetAddress receivedAddress =communicator.getDestinationAddress();

        //execute validations as per the template
        Simulator simulator = new Validation(receivedData);
        simulator.validate();

       // = Validation.validate(receivedData,recievedPort,receivedAddress);
        boolean isValid=  simulator.validateCommands(recievedPort,receivedAddress);
        boolean sendReply= simulator.validateSequence(droneState);

        if (isValid == false){
        communicator.sendCommand(error);
       }
        if (sendReply == true){
            communicator.sendCommand(reply);
        }

        // Clear the buffer after every message.
        }
    }



