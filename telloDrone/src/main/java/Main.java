import DroneWorld.*;
import java.util.Scanner;
import java.net.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket datagramSocket=new DatagramSocket();

        // taking IP and drone port as the input from the user
        System.out.println("Enter the IP Address");
        String IPAddress = scanner.nextLine();

        System.out.println("Enter the Drone Port");
        int dronePort = scanner.nextInt();
        scanner.nextLine();
        InetAddress droneAddress = InetAddress.getByName(IPAddress);

        // passing the droneaddress and port to the communicator
        Communicator communicator = new Communicator(droneAddress, dronePort,datagramSocket);

        Flier flier = new Flier();
        flier.fly();






    }
}
