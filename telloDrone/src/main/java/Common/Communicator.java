package Common;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

	public class Communicator {
	InetAddress destinationAddress=null;
	int destinationPort=0;
	DatagramSocket udpClient;
	DatagramPacket datagramPacket;

	public Communicator(DatagramSocket udpClient) throws Exception{
		this.udpClient=udpClient;
	}

	public Communicator(InetAddress destinationAddress, int dronePort, DatagramSocket udpClient) throws Exception {
		this.destinationAddress = destinationAddress;
		this.destinationPort = dronePort;
		this.udpClient = udpClient;
		System.out.println("Connected to Tello's IP:" + this.destinationAddress + "and Port:" + this.destinationPort);
	}

	public  void sendCommand(String droneMessage) throws Exception {
		byte[] sendData = droneMessage.getBytes(StandardCharsets.UTF_8);
		datagramPacket = new DatagramPacket(sendData, sendData.length, destinationAddress, destinationPort);
		udpClient.send(datagramPacket);

		if(datagramPacket.getPort()!=8890){
			System.out.println("Received drone message"+droneMessage);
			System.out.println("Sent " + droneMessage + " bytes to " + destinationAddress.toString() + ":" + destinationPort);
		}
		}
	public  InetAddress getDestinationAddress(){return destinationAddress;}
	public int getDestinationPort(){return destinationPort;}
	public DatagramSocket getUdpClient(){return udpClient;}
	public  String receiveData() throws Exception {
		byte[] receivedData;
		String receivedReply = null;
		receivedData = new byte[200];
		datagramPacket = new DatagramPacket(receivedData, 200);

			try {
				udpClient.receive(datagramPacket);
			} catch (SocketTimeoutException ex) {
				datagramPacket = null;
			}
			if(destinationPort==0){destinationPort=datagramPacket.getPort();}
			if(destinationAddress==null){destinationAddress=datagramPacket.getAddress();}
			if (datagramPacket != null ) {
				if(datagramPacket.getPort()==8889){
					System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
				}

				receivedReply = new String(receivedData, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
				if(datagramPacket.getPort() == 8889){
				System.out.println("Receive " + receivedReply);}

				}
				if (receivedReply == null ) {
					return ("Empty string");
				}
				Thread.sleep(1000);
				return receivedReply;

	}
}
