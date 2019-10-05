package Flier;

import Common.Communicator;
import Common.DroneState;
import Common.Status;
import org.junit.Test;

import java.net.DatagramSocket;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static org.junit.Assert.*;

public class FlierStatusThreadTest {

    Communicator statusCommunicator;
    public static DroneState droneState = new DroneState();

    public FlierStatusThreadTest() throws  Exception {
        DatagramSocket flierSocket= new DatagramSocket(8890);
        statusCommunicator =  new Communicator(flierSocket);

    }
    @Test
    public void run() {
        String receivedStatus =  null;
        try {
            receivedStatus=statusCommunicator.receiveData();
            String actual ="1;x:0;y:0;z:0;mpry:0,0,0;pitch:0;roll:0;yaw:0;vgx:0;vgy:0;vgz:0;templ:0;temph:0;tof:0;h:0;bat:40;baro:0.00;time:0;agx:0.00;agy:0.00;agz:0.00";
            assertEquals(receivedStatus,actual);
            Status status = new Status(receivedStatus);
            droneState.updateFlyingInfo(status);
            Thread.sleep(100);
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}