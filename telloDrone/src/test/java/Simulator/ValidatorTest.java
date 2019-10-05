package Simulator;

import Commands.TelloCommandValues;
import Common.DroneState;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ValidatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void validateCommands() throws IOException{
        String[] receivedData={"command"};
        DroneState droneState = new DroneState();

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
        int getIndex = commandValues.indexOf(receivedData[0]);

        String test= commandValues.get(getIndex).toString();

        assertEquals(receivedData[0],test);
        }

    @Test
    public void validateSequence() {


    }
}