package Common;
import Commands.TelloCommandValues;
import Flier.FlierStatusThread;
import java.util.Scanner;

public class SendAndReceive {

    public static final String sendAndReceive(String command,Communicator communicator, int retries)throws Exception{
         String response=null;
        while(retries>0){
        if(command.contains(TelloCommandValues.Command)){
            System.out.println("Putting drone in "+command+" mode");
            communicator.sendCommand(command);
        }
        else{
            if((FlierStatusThread.droneState.getBatteryPercentage()>20) && FlierStatusThread.droneState.getHighTemperature()<80){
                System.out.println(command+" mode");
                communicator.sendCommand(command);

                if(command.contains(TelloCommandValues.Left)){}
            }
            else {
                System.out.println("Putting drone in "+TelloCommandValues.Land+" mode");
                communicator.sendCommand(TelloCommandValues.Land);
                System.out.println("Landing safely due to low battery or high temperature");
            }

        }
        response = communicator.receiveData();
        if(response.equals("ok")){

        System.out.println(response);
        break;
        }
            retries--;
        }

        if(response==null || !response.equals("ok")) {
            return "not received anything";
        }
        else return response;
    }
}
