class Mission3 implements Mission {

    @Override
    public void sendCommand() {

        String[] droneCommand = { "command", "takeoff", "cw 360", "right 25", "land" };
        Communicator communicator = new Communicator();
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
