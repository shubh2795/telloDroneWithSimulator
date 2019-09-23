class Flyer {

    public void fly(int selectMission, Communicator communicator) throws Exception {
        String droneMessage;
        if (selectMission == 1) {
            Mission1 mission1 = new Mission1();
            String[] droneCommand = mission1.sendCommand();
            for (int i = 0; i < droneCommand.length; i++) {
                droneMessage = droneCommand[i];
                communicator.sendAndReceive(droneMessage);
            }

        } else if (selectMission == 2) {
            Mission2 mission2 = new Mission2();
            String[] droneCommand = mission2.sendCommand();
            for (int i = 0; i < droneCommand.length; i++) {
                droneMessage = droneCommand[i];
                communicator.sendAndReceive(droneMessage);
            }

        } else if (selectMission == 3) {
            Mission3 mission3 = new Mission3();
            String[] droneCommand = mission3.sendCommand();
            for (int i = 0; i < droneCommand.length; i++) {
                droneMessage = droneCommand[i];
                communicator.sendAndReceive(droneMessage);
            }

        } else {
            System.out.println("Please select a valid Mission Number");
        }
    }
}