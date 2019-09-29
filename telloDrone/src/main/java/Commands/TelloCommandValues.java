package Commands;


// Different Command Values for Tello drone

public class TelloCommandValues {

    //Enter command mode.
    public static final String Command = "command";

    // Drone takeoff..
    public static final String TakeOff = "takeoff";

    // Drone Land
    public static final String Land = "land";

    // Enable video stream.
    public static final String EnableVideoStream = "streamon";

    // Disable video stream.
    public static final String DisableVideoStream = "streamoff";

    // Emergency stop immediately
    public static final String Emergency = "emergency";

    //Fly upward x (x = 20 - 500 cm) user will enter the values of x
    public static final String Up = "up";

    //Fly downward x (x = 20 - 500 cm) user will enter the values of x
    public static final String Down = "down";

    //Fly left x (x = 20 - 500 cm) user will enter the values of x
    public static final String Left = "left";

    //Fly right x (x = 20 - 500 cm) user will enter the values of x
    public static final String Right = "right";

    //Fly forward x (x = 20 - 500 cm) user will enter the values of x
    public static final String Forward = "forward";

    //Fly backward x (x = 20 - 500 cm) user will enter the values of x
    public static final String Back = "back";

    //Drone Rotates clockwise x° (x = 1 - 360) user will enter the values of x, This is just drone rotation not a flip
    public static final String Cw = "cw";

    //Rotate counter-clockwise x° (x = 1-360) user will enter the values of x
    public static final String Ccw = "ccw";

    //Flip x (l = left, r = right, f = forward, b = back) user will enter the values of x.
    public static final String Flip = "flip";

    // Fly to “x” “y” “z” at “speed” (cm/s). go x y z speed “x”,“y” “z” user will enter the values of x y z
    public static final String Go = "go";

    // Fly at a curve according to the two given coordinates at “speed” (cm/s)
    public static final String Curve = "curve";

    //Drone Hovers in the air
    public static final String Stop = "stop";

    // Set current speed as xx (xx = 1-100 cm/s ).
    public static final String Speed = "speed";

    // Obtain current speed (cm/s).
    public static final String CurrentSpeed = "speed?";

    // Obtain current battery percentage.
    public static final String CurrentBattery = "battery?";

    // Obtain current drone flight time.
    public static final String CurrentFlyTime = "time?";

    //Obtain the Tello Drone SDK version.
    public static final String Sdk = "sdk?";

    // Obtain the Tello Drone serial number.
    public static final String Serial = "sn?";

}
