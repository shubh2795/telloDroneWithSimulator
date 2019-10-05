package Missions;

import Commands.Command;
import Commands.Land;
import Commands.TakeOff;
import Flier.Flier;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MissionTest {

    @Test
    public void sendCommand()  throws Exception {
        String[] droneCommand = { Command.getCommand()};
        String [] testCommand= {"command"};
        assertArrayEquals(testCommand,droneCommand);
//        Flier flier = new Flier();
//        flier.fly(droneCommand);
    }

    @Test
    public void sendTakeOff() throws Exception {
        String[] droneCommand = { TakeOff.getCommand()};
        String [] testCommand= {"takeoff"};
        assertArrayEquals(testCommand,droneCommand);
        Flier flier = new Flier();
        flier.fly(droneCommand);
    }

    @Test
    public void sendLand() throws Exception {
        String[] droneCommand = { Land.getCommand()};
        String [] testCommand= {"land"};
        assertArrayEquals(testCommand,droneCommand);
       Flier flier = new Flier();
        flier.fly(droneCommand);
    }

    @Test
    public void sendOtherCommands() {
    }

    @Test
    public void executeMission() {

    }
}