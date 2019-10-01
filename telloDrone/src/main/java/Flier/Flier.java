package Flier;
import java.util.Scanner;

import Common.Communicator;
import Missions.*;

public class Flier{

    public void fly(Communicator communicator) throws Exception {
        System.out.println("Select the drone mission");
        System.out.println("Enter 1 for Mission1: Takeoff Flip Land");
        System.out.println("Enter 2 for Mission2: Takeoff Forward Backward Land");
        System.out.println("Enter 3 for Mission3: Takeoff Right CW CCW Left Land");
        System.out.println("Enter 4 for a Custom Mission");
        System.out.println("Enter 5 for getting mission from a CSV/Json/XML file");

        Scanner scanner = new Scanner(System.in);
        int selectedMission = scanner.nextInt();

        if (selectedMission == 1){
        Mission1 mission = new Mission1();
        mission.sendCommand(communicator);

        }
        else if (selectedMission == 2){
        Mission2 mission = new Mission2();
        mission.sendCommand(communicator);
        }
        else if (selectedMission == 3){
        Mission3 mission = new Mission3();
            mission.sendCommand(communicator);
        }
        else if (selectedMission == 4) {
        CustomMission custommission = new CustomMission();
        custommission.sendCommand(communicator);

        }else if (selectedMission == 5) {

        }
        else {
        System.out.println("Select a valid drone mission");
        }
        }
}