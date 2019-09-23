import java.util.Scanner;
import java.net.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // taking IP and drone port as the input from the user
        System.out.println("Enter the IP Address");
        String IPAddress = scanner.nextLine();

        System.out.println("Enter the Drone Port");
        int dronePort = scanner.nextInt();
        scanner.nextLine();
        InetAddress droneAddress = InetAddress.getByName(IPAddress);

        // passing the droneaddress and port to the communicator
        Communicator communicator = new Communicator(droneAddress, dronePort);

//        System.out.println("Select the drone mission");
//        System.out.println("Enter 1 for Mission1: Takeoff Forward Backward Land");
//        System.out.println("Enter 2 for Mission2: Takeoff Flip Land");
//        System.out.println("Enter 3 for Mission3: Takeoff CW360 Right Land");

        //int selectMission = scanner.nextInt();
        Mission1 mission1= new Mission1();
        String[] requestArray=mission1.sendCommand();

        Flyer flyer = new Flyer();
        flyer.fly(requestArray, communicator);


    }
}
