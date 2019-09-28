import java.util.Scanner;
class Flier implements Runnable{
Communicator communicator = new Communicator();
DroneState droneState = new DroneState();

    Flier(){
//        Flier flier = new Flier();
//        Thread thread = new Thread(flier);
//        thread.start();
    }

    public void run(){
//        System.out.println("Thread for refreshing drone state every 100ms ");
//        //drone state method
//        String ReceivedMessage =  null;
//        try {
//            ReceivedMessage=communicator.receiveReply();
//            Status status = new Status(ReceivedMessage);
//            droneState.updateFlyingInfo(status);
//            Thread.sleep(100);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


    public void fly() throws Exception {
        System.out.println("Select the drone mission");
        System.out.println("Enter 1 for Mission1: Takeoff Forward Backward Land");
        System.out.println("Enter 2 for Mission2: Takeoff Flip Land");
        System.out.println("Enter 3 for Mission3: Takeoff CW360 Right Land");

        Scanner scanner = new Scanner(System.in);
        int selectedMission = scanner.nextInt();

        if (selectedMission == 1){
        Mission mission = new Mission1();
        mission.sendCommand();
        }
        else if (selectedMission == 2){
        Mission mission = new Mission2();
        mission.sendCommand();
        }
        else if (selectedMission == 3){
        Mission mission = new Mission3();
        mission.sendCommand();
        }else {
        System.out.println("Select a valid drone mission");
        }
        }
}