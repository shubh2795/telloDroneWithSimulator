package DroneWorld;
import java.util.Scanner;
import Missions.*;

public class Flier implements Runnable{

//DroneState droneState = new DroneState();

    public Flier(){
//        Flier flier = new Flier();
//        Thread thread = new Thread(flier);
//        thread.start();
    }

    public void run(){
//        System.out.println("Thread for refreshing drone state every 100ms ");
//        //drone state method
//        String ReceivedMessage =  null;
//        try {
//            ReceivedMessage=communicator.receiveData();
//            Status status = new Status(ReceivedMessage);
//            droneState.updateFlyingInfo(status);
//            Thread.sleep(100);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


    public void fly(Communicator communicator) throws Exception {
        System.out.println("Select the drone mission");
        System.out.println("Enter 1 for Mission1: Takeoff Forward Backward Land");
        System.out.println("Enter 2 for Mission2: Takeoff Flip Land");
        System.out.println("Enter 3 for Mission3: Takeoff CW360 Right Land");
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
        Mission mission = new Mission3();
        }
        else if (selectedMission == 4) {
        Mission custommission = new customMission();

        }else if (selectedMission == 5) {
            //Mission custommission = new customMission();
        }
        else {
        System.out.println("Select a valid drone mission");
        }
        }
}