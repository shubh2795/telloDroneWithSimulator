package Simulator;
import java.io.IOException;
import Commands.*;
import java.lang.String;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import Commands.*;

public class Validation {
//        if (receivedCommand.length>1){}
    public static boolean validate(String receivedCommand, int port, InetAddress address) throws IOException {


        String [] recievedCommand;
        recievedCommand =receivedCommand.split(" ");

        List<String> commandValues = new ArrayList<>();
        commandValues.add(Command.getCommand());
        commandValues.add(TakeOff.getCommand());
        commandValues.add(Up.getCommand());
        commandValues.add(Stop.getCommand());

       if(commandValues.contains(recievedCommand[0])== true){
           if(recievedCommand[0]== Command.getCommand()){
               if(recievedCommand[1]== TakeOff.getCommand()){
                   return true;
               }else{
                   System.out.println("Cannot execute the requested command without Takeoff");
               }
           }else{
               System.out.println("Cannot execute the requested command without Drone Entering the command mode");
           }
       }

       return false;

    }
    }

