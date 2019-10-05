package Simulator;

import Common.Communicator;
import Common.Status;
import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.Assert.*;

public class SimulatorStatusThreadTest {

    public SimulatorStatusThreadTest()throws Exception{


    }
    @Test
    public void run()throws Exception {
        DatagramSocket datagramSocketStatus = new DatagramSocket();
        Communicator communicatorStatus = new Communicator(InetAddress.getByName("127.0.0.1"),8890,datagramSocketStatus);
        Status status = new Status(Validator.droneState.getPitch(), Validator.droneState.getRoll(), Validator.droneState.getYaw(), Validator.droneState.getSpeedX(), Validator.droneState.getSpeedY(), Validator.droneState.getSpeedZ(),
                Validator.droneState.getLowTemperature(), Validator.droneState.getHighTemperature(), Validator.droneState.getFlightDistance(), Validator.droneState.getHeight(),
                Validator.droneState.getBatteryPercentage(), Validator.droneState.getBarometerMeasurement(), Validator.droneState.getMotorTime(),
                Validator.droneState.getAccelerationX(), Validator.droneState.getAccelerationY(), Validator.droneState.getAccelerationZ());

        String getMessageText = status.getMessageText();
        communicatorStatus.sendCommand(getMessageText);
        Thread.sleep(1000);

    }
}