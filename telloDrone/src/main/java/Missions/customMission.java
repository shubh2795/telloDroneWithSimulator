package Missions;

import Common.Communicator;

import java.util.Scanner;

public class customMission implements Mission {
    String[] droneCommand;
    String droneMessage;

    @Override
    public void sendCommand(Communicator communicator)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of commands in the Custom Mission");
        int numOfCommands = scanner.nextInt();
        System.out.println("Enter the commands for the Custom Mission");
        for(int i =0 ; i< numOfCommands;i++){
            droneCommand[i]= scanner.nextLine();
        }

        for (int i = 0; i < droneCommand.length; i++) {
            droneMessage = droneCommand[i];
            communicator.sendCommand(droneMessage);
            String response= communicator.receiveData();
            System.out.println(response);
        }
    }
}
