package Common;

import Commands.TelloCommandValues;
import Flier.FlierStatusThread;

public class SendAndReceive {
    public static final void sendAndReceive(String command,Communicator communicator)throws Exception{
        if(command.contains(TelloCommandValues.Command)){
            System.out.println("Putting drone in "+command+" mode");
            communicator.sendCommand(command);
        }
        else{
            if((FlierStatusThread.droneState.getBatteryPercentage()>20) && FlierStatusThread.droneState.getHighTemperature()<80){
                System.out.println("Putting drone in "+command+" mode");
                communicator.sendCommand(command);
            }
            else {
                System.out.println("Putting drone in "+TelloCommandValues.Land+" mode");
                communicator.sendCommand(TelloCommandValues.Land);
                System.out.println("Landing safely due to low battery or high temperature");
            }

        }
        String response = communicator.receiveData();
        System.out.println(response);
    }
}
