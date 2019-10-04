package Missions;
import Commands.*;
import Flier.Flier;


public class Mission3 extends Mission {


    @Override
    public void sendOtherCommands(Flier flier) throws Exception{

        String[] droneCommand = { Right.getCommand() ,Cw.getCommand(),Ccw.getCommand(),Left.getCommand()  };
        flier.fly(droneCommand);
    }
}
