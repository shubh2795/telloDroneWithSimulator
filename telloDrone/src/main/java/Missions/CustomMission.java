package Missions;
import Flier.Flier;
import java.util.Scanner;

public class CustomMission extends Mission {

    @Override
    public void sendOtherCommands(Flier flier) throws Exception{

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of commands in the Custom Mission");

        int numOfCommands = scanner.nextInt();

        String[] droneCommand = new String[numOfCommands];
        System.out.println("Enter the commands for the Custom Mission");
        for(int i =0 ; i< numOfCommands;i++){
            droneCommand[i]= scanner.nextLine();
        }
      flier.sendToCommunicator(droneCommand);

    }

}
