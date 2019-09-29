package DroneWorld;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Communicator {

	InetAddress destinationAddress;
	int destinationPort;
	DatagramSocket udpClient;



	public Communicator(){}

	public Communicator(DatagramSocket udpClient) throws Exception{
		this.udpClient=udpClient;
	}


	public Communicator(InetAddress destinationAddress, int dronePort, DatagramSocket udpClient) throws Exception {
		this.destinationAddress = destinationAddress;
		this.destinationPort = dronePort;
		this.udpClient = udpClient;
		System.out.println("Connected to Tello's IP:" + destinationAddress + "and Port:" + dronePort);
	}

	public int getDestinationPort()
	{
		return destinationPort;
	}
	public InetAddress getDestinationAddress()
	{
		return destinationAddress;
	}

	public  void sendCommand(String droneMessage) throws Exception {
		int Retries = 3;
		byte[] sendData;

		while (Retries > 0) {

			// code for sending commands
			sendData = droneMessage.getBytes(StandardCharsets.UTF_8);
			DatagramPacket datagramPacket = new DatagramPacket(sendData, sendData.length, destinationAddress, destinationPort);
			udpClient.send(datagramPacket);
			System.out.println("Sent " + droneMessage + " bytes to " + destinationAddress.toString() + ":" + destinationPort);
			break;

		}
		Retries--;
		System.out.println("Remaining retries for sending data to the drone: " + Retries);


		receiveData();
	}

	public  String receiveData() throws Exception {
		byte[] receivedData;
		int retries = 3;
		String receivedReply = null;
		receivedData = new byte[64];
		DatagramPacket datagramPacket = new DatagramPacket(receivedData, 64);
		destinationAddress=datagramPacket.getAddress();
		destinationPort=datagramPacket.getPort();
		while (retries > 0) {

			try {
				udpClient.receive(datagramPacket);
			} catch (SocketTimeoutException ex) {
				datagramPacket = null;
			}
			if (datagramPacket != null) {
				System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
				receivedReply = new String(receivedData, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
				System.out.println("Receive " + receivedReply);
				if (receivedReply.equals("ok")) {
					break;
				}
			}
			System.out.println("Remaining retries: " + retries);
			retries--;
		}
		if (receivedReply == null || !receivedReply.equals("ok")) {
			return "garbage values";

		}
		if ( receivedReply.equals("ok")) {
			Thread.sleep(3000);
		}

		return receivedReply;
	}

}
