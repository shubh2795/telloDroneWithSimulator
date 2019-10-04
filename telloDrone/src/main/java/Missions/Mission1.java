package Missions;
import Commands.*;

import Flier.Flier;

public class Mission1 extends Mission{

    @Override
    public void sendOtherCommands(Flier flier) throws Exception{
        String[] droneCommand = { Flip.getCommand(),Left.getCommand() };
        flier.sendToCommunicator(droneCommand);

    }
}