package Common;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Communicator {

	InetAddress destinationAddress=null;
	int destinationPort=0;
	DatagramSocket udpClient;
	DatagramPacket datagramPacket;

	public Communicator(){}
	public Communicator(DatagramSocket udpClient) throws Exception{
		this.udpClient=udpClient;
	}


	public Communicator(InetAddress destinationAddress, int dronePort, DatagramSocket udpClient) throws Exception {
		this.destinationAddress = destinationAddress;
		this.destinationPort = dronePort;
		this.udpClient = udpClient;
		System.out.println("Connected to Tello's IP:" + this.destinationAddress + "and Port:" + this.destinationPort);
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
			System.out.println("Received drone message"+droneMessage);
			byte[] sendData = droneMessage.getBytes(StandardCharsets.UTF_8);
			datagramPacket = new DatagramPacket(sendData, sendData.length, destinationAddress, destinationPort);
			udpClient.send(datagramPacket);
			System.out.println("Sent " + droneMessage + " bytes to " + destinationAddress.toString() + ":" + destinationPort);

	}

	public  String receiveData() throws Exception {
		byte[] receivedData;
		int retries = 3;
		String receivedReply = null;
		receivedData = new byte[200];
		datagramPacket = new DatagramPacket(receivedData, 200);
		//while (retries > 0) {

			try {
				udpClient.receive(datagramPacket);
			} catch (SocketTimeoutException ex) {
				datagramPacket = null;
			}
			if(destinationPort==0){destinationPort=datagramPacket.getPort();}
			if(destinationAddress==null){destinationAddress=datagramPacket.getAddress();}
			if (datagramPacket != null ) {
				if(datagramPacket.getPort()==8889)
					System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
				receivedReply = new String(receivedData, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
				if(datagramPacket.getPort() == 8889){
				System.out.println("Receive " + receivedReply);}
				//if (receivedReply.equals("ok")) {
		//			break;
				}

		//	System.out.println("Remaining retries: " + retries);
		//	retries--;

		if (receivedReply == null ) {
			return ("nothiing string");

		}
		Thread.sleep(1000);
		return receivedReply;

	}

}
