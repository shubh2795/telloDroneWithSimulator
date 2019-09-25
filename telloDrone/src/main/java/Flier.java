class Flier implements Runnable{
Communicator communicator = new Communicator();
DroneState droneState = new DroneState();

    Flier(){
        Flier flier = new Flier();
        Thread thread = new Thread(flier);
        thread.start();
    }

    public void run(){
        System.out.println("Thread for refreshing drone state every 100ms ");
        //drone state method
        String ReceivedMessage =  null;
        try {
            ReceivedMessage=communicator.receiveReply();
            Status status = new Status(ReceivedMessage);
            droneState.updateFlyingInfo(status);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void fly() throws Exception {
        Mission mission = new Mission1();
    mission.performMission();
    }
}