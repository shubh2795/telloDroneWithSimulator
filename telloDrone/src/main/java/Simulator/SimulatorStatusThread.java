package Simulator;
import Common.Communicator;
import Common.Status;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class SimulatorStatusThread extends Thread {
    Communicator communicatorStatus;
    public SimulatorStatusThread()throws Exception{
         DatagramSocket datagramSocketStatus = new DatagramSocket();
         communicatorStatus = new Communicator(InetAddress.getByName("127.0.0.1"),8890,datagramSocketStatus);
    }

    public void run(){

        while(true){
            try {
                Status status = new Status(Validator.droneState.getPitch(), Validator.droneState.getRoll(), Validator.droneState.getYaw(), Validator.droneState.getSpeedX(), Validator.droneState.getSpeedY(), Validator.droneState.getSpeedZ(),
                    Validator.droneState.getLowTemperature(), Validator.droneState.getHighTemperature(), Validator.droneState.getFlightDistance(), Validator.droneState.getHeight(),
                    Validator.droneState.getBatteryPercentage(), Validator.droneState.getBarometerMeasurement(), Validator.droneState.getMotorTime(),
                    Validator.droneState.getAccelerationX(), Validator.droneState.getAccelerationY(), Validator.droneState.getAccelerationZ());

                String getMessageText = status.getMessageText();
                communicatorStatus.sendCommand(getMessageText);
                Thread.sleep(1000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
