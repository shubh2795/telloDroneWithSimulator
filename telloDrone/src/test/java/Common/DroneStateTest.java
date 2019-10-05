package Common;

import org.junit.Test;

import java.net.DatagramSocket;
import java.util.Date;

import static org.junit.Assert.*;

public class DroneStateTest {
    private boolean inCommandMode;
    private boolean hasTakenOff;
    private boolean videoStreamOn;
    private Date stateTimestamp;
    private Double currentFlightTime;
    private Double positionX;
    private Double positionY;
    private Double positionZ;
    private Integer pitch;
    private Integer roll;
    private Integer yaw;
    private Integer speedX;
    private Integer speedY;
    private Integer speedZ;
    private Integer lowTemperature;
    private Integer highTemperature;
    private Integer flightDistance;
    private Integer height;
    private Integer batteryPercentage;
    private Double barometerMeasurement;
    private Integer motorTime;
    private Double accelerationX;
    private Double accelerationY;
    private Double accelerationZ;
    private int orientation;

    @Test
    public void isInCommandModeTest() {

    }

    @Test
    public void setInCommandModeTest() {
        DroneState droneState= new DroneState();
        assertEquals(false, droneState.isInCommandMode());
        droneState.setInCommandMode(true);
        droneState.resetState();
    }

    @Test
    public void hasTakenOff() {
    }

    @Test
    public void setHasTakenOff() {
        DroneState droneState= new DroneState();
        assertEquals(false,droneState.hasTakenOff());
        droneState.setHasTakenOff(true);
        droneState.resetState();
    }

    @Test
    public void isVideoStreamOn() {
    }

    @Test
    public void setVideoStreamOn() {
        DroneState droneState= new DroneState();
        assertEquals(false,droneState.isVideoStreamOn());
        droneState.setVideoStreamOn(true);

    }

    @Test
    public void getCurrentFlightTime() {
    }

    @Test
    public void setCurrentFlightTime() {
        DroneState droneState= new DroneState();
        Double time=0.0;
        assertEquals(time,droneState.getCurrentFlightTime());

        droneState.setCurrentFlightTime(12.5);
    }

    @Test
    public void updateFlyingInfo() throws Exception {
        DroneState droneState= new DroneState();
        DatagramSocket ds= new DatagramSocket(8890);
        //Communicator communicator= new Communicator(ds);
        String statusReceived= "mid:-1;x:0;y:0;z:0;mpry:0,0,0;pitch:0;roll:0;yaw:0;vgx:0;vgy:0;vgz:0;templ:0;temph:40;tof:0;h:0;bat:30;baro:0.00;time:0;agx:0.00;agy:0.00;agz:0.00";
        Status status= new Status(statusReceived);
        droneState.updateFlyingInfo(status);
        assertEquals(droneState.getPitch(),status.getPitch());
        assertEquals(droneState.getRoll(),status.getRoll());
        assertEquals(droneState.getYaw(),status.getYaw());
        assertEquals(droneState.getSpeedX(),status.getSpeedX());
        assertEquals(droneState.getSpeedY(),status.getSpeedY());
        assertEquals(droneState.getSpeedZ(),status.getSpeedZ());
        assertEquals(droneState.getLowTemperature(),status.getLowTemperature());
        assertEquals(droneState.getHighTemperature(),status.getHighTemperature());
        assertEquals(droneState.getFlightDistance(),status.getFlightDistance());
        assertEquals(droneState.getHeight(),status.getHeight());

        assertEquals(droneState.getBatteryPercentage(),status.getBatteryPercentage());
        assertEquals(droneState.getBarometerMeasurement(),status.getBarometerMeasurement());
        assertEquals(droneState.getMotorTime(),status.getMotorTime());

        assertEquals(droneState.getAccelerationX(),status.getAccelerationX());
        assertEquals(droneState.getAccelerationY(),status.getAccelerationY());
        assertEquals(droneState.getAccelerationZ(),status.getAccelerationZ());
    }



    @Test
    public void move() {
        DroneState droneState=new DroneState();
        droneState.move(0.0,0.0,0.0);
        Double value=0.0;
        assertEquals(value,droneState.getPositionX());
        assertEquals(value,droneState.getPositionY());
        assertEquals(value,droneState.getPositionZ());
    }

    @Test
    public void rotate() {
        DroneState droneState= new DroneState();
        droneState.rotate(0);
        assertEquals(0,droneState.getOrientation());
    }

    @Test
    public void getPositionX() {
    }

    @Test
    public void getPositionY() {
    }

    @Test
    public void getPositionZ() {
    }

    @Test
    public void getPitch() {
    }

    @Test
    public void getRoll() {
    }

    @Test
    public void getYaw() {
    }

    @Test
    public void getSpeedX() {
    }

    @Test
    public void getSpeedY() {
    }

    @Test
    public void getSpeedZ() {
    }

    @Test
    public void getAccelerationX() {
    }

    @Test
    public void getAccelerationY() {
    }

    @Test
    public void getAccelerationZ() {
    }

    @Test
    public void getLowTemperature() {
    }

    @Test
    public void getHighTemperature() {
    }

    @Test
    public void getFlightDistance() {
    }

    @Test
    public void getHeight() {
    }

    @Test
    public void getBatteryPercentage() {
    }

    @Test
    public void getBarometerMeasurement() {
    }

    @Test
    public void getMotorTime() {
    }

    @Test
    public void getOrientationTest() {
        DroneState droneState= new DroneState();
        int value=0;
        assertEquals(value,droneState.getOrientation());
    }
    @Test
    public void getPositionTest(){

    }
}