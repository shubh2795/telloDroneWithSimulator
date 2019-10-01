import DroneWorld.Communicator;
import DroneWorld.Flier;
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

        Flier flier = new Flier();
        flier.start();
        flier.fly(communicator);
    }
}
