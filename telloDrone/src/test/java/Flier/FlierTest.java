package Flier;

import Common.Communicator;
import Common.SendAndReceive;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FlierTest {

    @Test
    public void fly() throws Exception {
        DatagramSocket udpClient= new DatagramSocket();
        InetAddress droneAddress = InetAddress.getByName("127.0.0.1");
        Communicator communicator= new Communicator(droneAddress,8889,udpClient);

        String[] droneCommand={"command"};
        for (int i = 0; i < droneCommand.length; i++) {

            String reply;
            String[] droneMessageSplitted;
            int retries = 3;
            int delX = 0, delY = 0, delZ = 0, orientation = 0;
            String droneMessage = droneCommand[i];
            reply= SendAndReceive.sendAndReceive(droneMessage,communicator,retries);
            assertEquals("ok",reply);
            droneMessageSplitted = droneMessage.split(" ");
            assertEquals("command",droneMessageSplitted[0]);

            FlierStatusThread.droneState.move(delX, delY, delZ);
            FlierStatusThread.droneState.rotate(orientation);


        }
    }
}