class Mission2 implements Mission {

    @Override
    public void sendCommand() {

        Communicator communicator = new Communicator();
        String[] droneCommand = { "command", "takeoff", "flip r", "left 25", "land" };
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
