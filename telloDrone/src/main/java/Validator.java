
import java.io.IOException;
import java.lang.String;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import Commands.TelloCommandValues;
import DroneWorld.Communicator;
import DroneWorld.DroneState;
import DroneWorld.Status;


public class Validator extends Thread{

    String[] receivedData;
    DroneState droneState = new DroneState();
    Communicator communicatorStatus;

    public Validator(String receivedData) throws Exception{

        this.receivedData = receivedData.split(" ");
        //response port
        DatagramSocket datagramSocketStatus = new DatagramSocket();
        communicatorStatus = new Communicator(InetAddress.getByName("127.0.0.1"),8890,datagramSocketStatus);
    }

    boolean validateCommands() throws IOException {
        //Creating an array list for commands validation

        ArrayList commandValues = new ArrayList();

        commandValues.add(TelloCommandValues.Command);
        commandValues.add(TelloCommandValues.TakeOff);
        commandValues.add(TelloCommandValues.Land);
        commandValues.add(TelloCommandValues.Stop);
        commandValues.add(TelloCommandValues.Speed);
        commandValues.add(TelloCommandValues.Serial);
        commandValues.add(TelloCommandValues.Sdk);
        commandValues.add(TelloCommandValues.Up);
        commandValues.add(TelloCommandValues.Right);
        commandValues.add(TelloCommandValues.Left);
        commandValues.add(TelloCommandValues.Forward);
        commandValues.add(TelloCommandValues.Back);
        commandValues.add(TelloCommandValues.Down);
        commandValues.add(TelloCommandValues.Go);
        commandValues.add(TelloCommandValues.Flip);
        commandValues.add(TelloCommandValues.EnableVideoStream);
        commandValues.add(TelloCommandValues.Emergency);
        commandValues.add(TelloCommandValues.DisableVideoStream);
        commandValues.add(TelloCommandValues.Cw);
        commandValues.add(TelloCommandValues.Ccw);
        commandValues.add(TelloCommandValues.Curve);
        commandValues.add(TelloCommandValues.CurrentSpeed);
        commandValues.add(TelloCommandValues.CurrentBattery);
        commandValues.add(TelloCommandValues.CurrentFlyTime);

        System.out.println("Validating Commands");

        if (receivedData.length==1 && commandValues.contains(receivedData[0])) {
            System.out.println("Received" + receivedData[0]);
            return true;
        } else if (commandValues.contains(receivedData[0]) == false) {
            return false;
        }

        if ((commandValues.contains(receivedData[0])) && (receivedData.length==2)) {
            int getIndex = commandValues.indexOf(receivedData[0]);
            if (getIndex >= 7 && getIndex <= 13) {
                int distance = Integer.parseInt(receivedData[1]);
                if (distance < 20 || distance > 500) {
                    System.out.println("Out of range distance added to " + receivedData[0]);
                    return false;
                }
                else{return true;}

            } else if (getIndex == 18 || getIndex == 19) {
                int distance = Integer.parseInt(receivedData[1]);
                if (distance < 1 || distance > 360) {
                    System.out.println("Out of range degree added to " + receivedData[0]);
                    return false;
                }
                else {return true;}
            } else if (getIndex == 14) {
                if ((receivedData[1] == "r") || receivedData[1] == "l" || receivedData[1] == "f" || receivedData[1] == "b") {
                    return true;
                } else {
                    System.out.println("invalid attribute added to " + receivedData[0]);
                    return false;
                }
            }
        }

        return false;

    }


    void validateSequence(Communicator communicator) throws Exception {
        //Set in command mode
        if (receivedData[0].equals(TelloCommandValues.Command)) {
        droneState.setInCommandMode(true);
        communicator.sendCommand("ok");
       }

       else if(receivedData[0].equals(TelloCommandValues.TakeOff)){
        if(droneState.isInCommandMode()){
            droneState.setHasTakenOff(true);
            communicator.sendCommand("ok");
        }else{
            System.out.println("can not take off, not yet in command mode");
            communicator.sendCommand("error");
        }
        }

       else if(droneState.isInCommandMode())
        {
            if((receivedData[0].equals(TelloCommandValues.CurrentBattery))){
              communicator.sendCommand("Current Battey:65%");

            }
            else if(receivedData[0].equals(TelloCommandValues.Sdk) ){
                communicator.sendCommand("ABCDEFG");
            }
            else if(receivedData[0].equals(TelloCommandValues.Serial)){
                communicator.sendCommand("Flying with Tello:SHUHBH2795");
        }
            else if(droneState.isInCommandMode()&& droneState.hasTakenOff()){
                communicator.sendCommand("ok");
                System.out.println(receivedData);

               }
           }

    }
    public void run(){
        while(true){
            try {
                Status status = new Status(droneState.getPitch(), droneState.getRoll(), droneState.getYaw(), droneState.getSpeedX(), droneState.getSpeedY(), droneState.getSpeedZ(),
                        droneState.getLowTemperature(), droneState.getHighTemperature(), droneState.getFlightDistance(), droneState.getHeight(),
                        droneState.getBatteryPercentage(), droneState.getBarometerMeasurement(), droneState.getMotorTime(),
                        droneState.getAccelerationX(), droneState.getAccelerationY(), droneState.getAccelerationZ());

                String getMessageText = status.getMessageType();
                communicatorStatus.sendCommand(getMessageText);
                Thread.sleep(1000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}