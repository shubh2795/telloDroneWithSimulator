import Commands.TelloCommandValues;
public class Mission1 implements Mission {

    @Override
    public void sendCommand() {
        // passing commands from mission to communicator as per the rubric comments by the TA
        Communicator communicator = new Communicator();
        String[] droneCommand = { TelloCommandValues.COMMAND_MODE, TelloCommandValues.TAKE_OFF,TelloCommandValues.LAND };

        for(int i=0;i<droneCommand.length;i++ ){
            try {
                communicator.sendCommand(droneCommand[i]);
            }
            catch (Exception e){
                System.out.println(e);
            }
            }
    }
}