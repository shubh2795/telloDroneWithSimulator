import java.net.DatagramSocket;

public interface Messages {
    void doAction(Communicator communicator, String request, DatagramSocket udpClient) throws Exception;
}
