package Simulator;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import DroneWorld.Communicator;


public abstract class Simulator {

    String receivedCommand;
    int port;
    InetAddress address;

    //Template method pattern
    abstract  boolean validateCommands(String receivedCommand, int port, InetAddress address)throws IOException ;
    abstract void validateSequence()throws IOException;

    public final void validate()throws Exception{
        // template

        validateCommands(receivedCommand,  port,  address);
        validateSequence();
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
        Simulator simulator = new Validation();
        simulator.validate();

       // = Validation.validate(receivedData,recievedPort,receivedAddress);
        boolean isValid= false;

       if (isValid == false){
        communicator.sendCommand(error);
       }
       else{
        //communicator.sendCommand(error);
       }


        // Clear the buffer after every message.
        }
    }



