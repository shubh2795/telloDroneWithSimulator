import Common.Communicator;
import Flier.*;
import Missions.*;

import java.util.Scanner;
import java.net.*;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        DatagramSocket datagramSocket=new DatagramSocket();

        // taking IP and drone port as the input from the user
        System.out.println("Enter the IP Address");
        String IPAddress = scanner.next();

        System.out.println("Enter the Drone Port");
        int dronePort = scanner.nextInt();
        scanner.nextLine();
        InetAddress droneAddress = InetAddress.getByName(IPAddress);

        // passing the droneaddress and port to the communicator
        Communicator communicator = new Communicator(droneAddress, dronePort,datagramSocket);

        Flier flier = new Flier(communicator);

        System.out.println("Select the drone mission");
        System.out.println("Enter 1 for Mission1: Takeoff Flip Land");
        System.out.println("Enter 2 for Mission2: Takeoff Forward Backward Land");
        System.out.println("Enter 3 for Mission3: Takeoff Right CW CCW Left Land");
        System.out.println("Enter 4 for a Custom Mission");
  //      System.out.println("Enter 5 for getting mission from a CSV/Json/XML file");


        int selectedMission = scanner.nextInt();

        if (selectedMission == 1){
            Mission mission = new Mission1();
            mission.executeMission(flier);
        }
        else if (selectedMission == 2){
            Mission mission = new Mission2();
            mission.executeMission(flier);
        }
        else if (selectedMission == 3){
            Mission mission = new Mission3();
            mission.executeMission(flier);
        }
        else if (selectedMission == 4) {
            Mission mission = new CustomMission();
            mission.executeMission(flier);
        }
        else {
            System.out.println("Select a valid drone mission");
        }

        FlierStatusThread flierStatusThread= new FlierStatusThread();
        flierStatusThread.start();

        }
}
