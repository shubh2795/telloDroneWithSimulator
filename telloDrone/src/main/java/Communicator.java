import java.net.*;
import java.nio.charset.StandardCharsets;

class Communicator {

	InetAddress droneAddress;
	int dronePort;
	DatagramSocket udpClient;

	Communicator(){}

	Communicator(InetAddress droneAddress, int dronePort) throws Exception {
		this.droneAddress = droneAddress;
		this.dronePort = dronePort;
		this.udpClient = new DatagramSocket();
		udpClient.setSoTimeout(1000);
		System.out.println("Connected to Tello's IP:" + droneAddress + "and Port:" + dronePort);
	}


	public  void sendCommand(String droneMessage) throws Exception {
		int Retries = 3;
		byte[] sendData;

		while (Retries > 0) {

			// code for sending commands
			sendData = droneMessage.getBytes(StandardCharsets.UTF_8);
			DatagramPacket datagramPacket = new DatagramPacket(sendData, sendData.length, droneAddress, dronePort);
			udpClient.send(datagramPacket);
			System.out.println("Sent " + droneMessage + " bytes to " + droneAddress.toString() + ":" + dronePort);
			break;

		}
		Retries--;
		System.out.println("Remaining retries for sending data to the drone: " + Retries);
		receiveReply(droneMessage);
	}

	public  String receiveReply(String droneMessage) throws Exception {
		byte[] receivedData;
		int retries = 3;
		String droneReply = null;
		while (retries > 0) {

			receivedData = new byte[64];
			DatagramPacket datagramPacket = new DatagramPacket(receivedData, 64);
			try {
				udpClient.receive(datagramPacket);
			} catch (SocketTimeoutException ex) {
				datagramPacket = null;
			}
			if (datagramPacket != null) {
				System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
				droneReply = new String(receivedData, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
				System.out.println("Receive " + droneReply);
				if (droneReply.equals("ok")) {
					break;
				}
			}
			System.out.println("Remaining retries: " + retries);
			retries--;
		}
		if (droneReply == null || !droneReply.equals("ok")) {
			return "garbage values";

		}
		if ((droneMessage.equals("takeoff")) || (droneMessage.equals("cw 360")) || (droneMessage.equals("land"))
				|| (droneMessage.equals("stop")) || (droneMessage.equals("left 25"))
				|| (droneMessage.equals("right 25")) || (droneMessage.equals("flip r")) && droneReply.equals("ok")) {
			Thread.sleep(3000);
		}
		return droneReply;
	}

}
