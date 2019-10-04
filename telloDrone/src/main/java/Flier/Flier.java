package Flier;
import Commands.TelloCommandValues;
import Common.Communicator;
import Common.DroneState;
import Common.SendAndReceive;

import java.util.Scanner;

public class Flier {

    Communicator communicator;
    public Flier(){

    }

       public Flier(Communicator communicator) {
        this.communicator = communicator;
        }

        public void fly(String[] droneCommand) throws Exception {

        for (int i = 0; i < droneCommand.length; i++) {
            String reply;
            String [] droneMessageSplited;
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the number of retries");
            int retries = sc.nextInt();


            int delX=0,delY=0,delZ=0,orientation=0;
            String droneMessage = droneCommand[i];
            reply=SendAndReceive.sendAndReceive(droneMessage,communicator,retries);
            if(reply.equals("ok")) {

                if(droneMessage.equals(TelloCommandValues.TakeOff))
                {
                    FlierStatusThread.droneState.setHasTakenOff(true);
                }
                else if(droneMessage.equals(TelloCommandValues.Command))
                {
                    FlierStatusThread.droneState.setInCommandMode(true);
                }
                else{


                droneMessageSplited = droneMessage.split(" ");
                switch (droneMessageSplited[0]) {
                    case TelloCommandValues.Left:
                        delX = -Integer.parseInt(droneMessageSplited[1]);
                        break;
                    case TelloCommandValues.Right:
                        delX = Integer.parseInt(droneMessageSplited[1]);
                        break;
                    case TelloCommandValues.Up:
                        delY = Integer.parseInt(droneMessageSplited[1]);
                        break;
                    case TelloCommandValues.Down:
                        delY = -Integer.parseInt(droneMessageSplited[1]);
                        break;
                    case TelloCommandValues.Forward:
                        delZ = Integer.parseInt(droneMessageSplited[1]);
                        break;
                    case TelloCommandValues.Back:
                        delZ = -Integer.parseInt(droneMessageSplited[1]);
                        break;
                    case TelloCommandValues.Ccw:
                        orientation = Integer.parseInt((droneMessageSplited[1]));
                        break;
                    case TelloCommandValues.Cw:
                        orientation = -Integer.parseInt((droneMessageSplited[1]));
                        break;

                }}
                FlierStatusThread.droneState.move(delX, delY, delZ);
                FlierStatusThread.droneState.rotate(orientation);
                System.out.println(FlierStatusThread.droneState.getPosition());

            }


        }
    }
}
