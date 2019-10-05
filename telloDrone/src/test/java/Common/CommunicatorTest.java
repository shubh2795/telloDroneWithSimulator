package Common;

import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.Assert.*;

public class CommunicatorTest {
    @Test
    public void constructorTest() throws Exception{
        DatagramSocket udpClient= new DatagramSocket();
        InetAddress droneAddress = InetAddress.getByName("127.0.0.1");
        Communicator communicator = new Communicator(droneAddress, 8889,udpClient);
        Communicator communicator1= new Communicator(udpClient);
        assertEquals(8889, communicator.getDestinationPort());
        assertEquals(InetAddress.getByName("127.0.0.1"), communicator.getDestinationAddress());
        assertEquals(udpClient,communicator.getUdpClient());
        assertEquals(udpClient,communicator1.getUdpClient());
    }
    @Test
    public void sendCommand() throws Exception{
        DatagramSocket udpClient= new DatagramSocket();
        InetAddress droneAddress = InetAddress.getByName("127.0.0.1");
        Communicator communicator2 = new Communicator(droneAddress,8889,udpClient);
        communicator2.sendCommand("command");
    }

    @Test
    public void receiveData()throws Exception {
        String expectedReply="ok";
        DatagramSocket udpClient= new DatagramSocket();
        InetAddress droneAddress = InetAddress.getByName("127.0.0.1");
        Communicator communicator2 = new Communicator(droneAddress,8889,udpClient);
        communicator2.sendCommand("command");
        communicator2.receiveData().compareTo(expectedReply);
    }
}