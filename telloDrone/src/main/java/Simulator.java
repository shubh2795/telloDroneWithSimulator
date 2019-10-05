
import Common.Communicator;
import Simulator.*;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Simulator {

    public static void main(String[] args) throws Exception {

        DatagramSocket UdpServer = new DatagramSocket(8889);
        Communicator communicator = new Communicator(UdpServer);
        String receivedData;
            receivedData = communicator.receiveData();
            System.out.println(receivedData);
            Validator validator = new Validator(receivedData);
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
