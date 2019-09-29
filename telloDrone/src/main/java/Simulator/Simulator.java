package Simulator;
import java.net.DatagramSocket;
import java.net.InetAddress;
import DroneWorld.Communicator;


public abstract class Simulator {
    public static final String reply = "ok";
    public static final String error = "Invalid Command";

    abstract void validateCommands();
    abstract void validateSequence();




    public static void main(String[] args) throws Exception {
        // Step 1 : Create a socket to listen at port 8889
        DatagramSocket UdpServer = new DatagramSocket(8889);
        Communicator communicator = new Communicator(UdpServer);
        String receivedData;
        receivedData=communicator.receiveData();
        int recievedPort = communicator.getDestinationPort();
        InetAddress receivedAddress =communicator.getDestinationAddress();

        boolean isValid= Validation.validate(receivedData,recievedPort,receivedAddress);

       if (isValid == false){
        communicator.sendCommand(error);
       }
       else{
        //communicator.sendCommand(error);
       }


        // Clear the buffer after every message.
        }
    }



