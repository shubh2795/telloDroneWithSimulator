
import Common.Communicator;
import Simulator.*;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Simulator {


    String receivedCommand;
    int port;
    InetAddress address;

    public static void main(String[] args) throws Exception {
        // Step 1 : Create a socket to listen at port 8889
        DatagramSocket UdpServer = new DatagramSocket(8889);
        //Use communicators send and recv methods to communicate
        Communicator communicator = new Communicator(UdpServer);
        String receivedData;
        //Same code as in while because  new object creates every time
            //receivedData = null;
            receivedData = communicator.receiveData();
            System.out.println(receivedData);

            Validator validator = new Validator(receivedData);
            //validator.start();
        boolean isValid = validator.validateCommands();
        if (isValid == false) {
            communicator.sendCommand("error");
        } else {
            validator.validateSequence(communicator);
        }


        SimulatorStatusThread simulatorStatusThread =new SimulatorStatusThread();
            if(Validator.droneState.isInCommandMode())
            {
                simulatorStatusThread.start();
            }


            while (true) {
            receivedData = null;
            receivedData = communicator.receiveData();
            System.out.println(receivedData);




            isValid = validator.validateCommands();
            if (isValid == false) {
               communicator.sendCommand("error");
            } else {
                validator.validateSequence(communicator);
            }

        }
    }


}
