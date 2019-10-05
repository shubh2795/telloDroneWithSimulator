package Common;

import Commands.TelloCommandValues;
import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.Assert.*;

public class SendAndReceiveTest {

    @Test
    public void sendAndReceive() throws Exception {

        DatagramSocket udpClient= new DatagramSocket();
        InetAddress droneAddress = InetAddress.getByName("127.0.0.1");
        Communicator communicator= new Communicator(droneAddress,8889,udpClient);
        int retries=3;
        String command1= TelloCommandValues.Command;
        String command2= TelloCommandValues.TakeOff;
        String command3=TelloCommandValues.Land;
        try{
        SendAndReceive.sendAndReceive(command1,communicator,retries);
        SendAndReceive.sendAndReceive(command2,communicator,retries);
        SendAndReceive.sendAndReceive(command3,communicator,retries);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}