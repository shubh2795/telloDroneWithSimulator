package Missions;

import DroneWorld.Communicator;


public interface Mission {
    // ABSTRACT METHOD
    public void sendCommand(Communicator communicator)throws Exception;
}
