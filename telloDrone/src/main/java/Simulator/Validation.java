package Simulator;
import java.io.IOException;
import Commands.*;
import java.lang.String;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import DroneWorld.Communicator;
import DroneWorld.DroneState;

public class Validation extends Simulator {



    String[] recievedCommand;
    String recievedData;

    List<String> commandValues = new ArrayList<>();

    Validation(String recievedCommand) {
        recievedData = recievedCommand;
        this.recievedCommand = recievedData.split(" ");
        commandValues.add(Command.getCommand());
        commandValues.add(TakeOff.getCommand());
        commandValues.add(Land.getCommand());
        commandValues.add(Stop.getCommand());
        commandValues.add(Speed.getCommand());
        commandValues.add(Serial.getCommand());
        commandValues.add(Sdk.getCommand());
        commandValues.add(Up.getCommand());
        commandValues.add(Right.getCommand());
        commandValues.add(Left.getCommand());
        commandValues.add(Forward.getCommand());
        commandValues.add(Back.getCommand());
        commandValues.add(Down.getCommand());
        commandValues.add(Go.getCommand());
        commandValues.add(Flip.getCommand());
        commandValues.add(EnableVideoStream.getCommand());
        commandValues.add(Emergency.getCommand());
        commandValues.add(DisableVideoStream.getCommand());
        commandValues.add(Cw.getCommand());
        commandValues.add(Ccw.getCommand());
        commandValues.add(Curve.getCommand());
        commandValues.add(CurrentSpeed.getCommand());
        commandValues.add(CurrentBattery.getCommand());
        commandValues.add(CurrentFlyTime.getCommand());


    }

    @Override
    boolean validateCommands(int port, InetAddress address) throws IOException {

        if ((commandValues.contains(recievedCommand[0]) && recievedCommand[1].isEmpty())) {
            return true;
        } else if (commandValues.contains(recievedCommand[0]) == false) {
            return false;
        }

        if ((commandValues.contains(recievedCommand[0])) && (recievedCommand[1].isEmpty() == false)) {
            int getIndex = commandValues.indexOf(recievedCommand[0]);
            if (getIndex >= 7 && getIndex <= 13) {
                int distance = Integer.parseInt(recievedCommand[1]);
                if (distance < 20 || distance > 500) {
                    System.out.println("Out of range distance added to " + recievedCommand[0]);
                    return false;
                }
            } else if (getIndex == 18 || getIndex == 19) {
                int distance = Integer.parseInt(recievedCommand[1]);
                if (distance < 1 || distance > 360) {
                    System.out.println("Out of range degree added to " + recievedCommand[0]);
                    return false;
                }
            } else if (getIndex == 14) {
                if ((recievedCommand[1] == "r") || recievedCommand[1] == "l" || recievedCommand[1] == "f" || recievedCommand[1] == "b") {
                    return true;
                } else {
                    System.out.println("invalid attribute added to " + recievedCommand[0]);
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    boolean validateSequence(DroneState droneState) throws Exception {
        //Set in command mode
        if (recievedCommand[0] == Command.getCommand()) {
        droneState.setInCommandMode(true);
        return true;
       }

       else if(recievedCommand[0] == TakeOff.getCommand()){
        boolean isInCommandMode= droneState.isInCommandMode();
        if(isInCommandMode){
            droneState.setHasTakenOff(true);
            return true;
        }else{
            droneState.setHasTakenOff(false);
            return false;
        }
        }
       else{
           if(droneState.isInCommandMode()&& droneState.hasTakenOff()){
                if((recievedCommand[0] == CurrentBattery.getCommand())){
                   Communicator communicator = new Communicator();
                   communicator.sendCommand("Current Battey:65%");

                }
               if(recievedCommand[0] == Sdk.getCommand() ){
                   Communicator communicator = new Communicator();
                   communicator.sendCommand("ABCDEFG");
               }if(recievedCommand[0] == Serial.getCommand()){
                   Communicator communicator = new Communicator();
                   communicator.sendCommand("Flying with Tello:SHUHBH2795");
               }
               else{
                    if(droneState.hasTakenOff() && droneState.isInCommandMode()){
                   return true;}
                    else return false;
               }
           }
        }
    return false;
    }
}