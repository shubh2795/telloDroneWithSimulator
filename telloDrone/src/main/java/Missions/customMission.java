package Missions;

import java.util.Scanner;

public class customMission extends Mission {
    String[] droneCommand;


    void customMission(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of commands in the Custom Mission");
        int numOfCommands = scanner.nextInt();
        System.out.println("Enter the commands for the Custom Mission");
        for(int i =0 ; i< numOfCommands;i++){
            droneCommand[i]= scanner.nextLine();

        }
        Mission.sendCommand(droneCommand);
    }
    @Override
    public void selectMessages(){}
}
