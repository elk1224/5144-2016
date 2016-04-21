package org.usfirst.frc.team5144.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //USB (number on the driver station)
    public static final int joystickLeftChannel = 0;
    public static final int joystickRightChannel = 1;
    public static final int xboxControllerChannel = 2;
    
	//DIGITAL
    public static final int limitBackChannel = 0; 
    public static final int limitFrontChannel = 1;
    
    //ANALOG
    public static final int ultrasonicChannel = 3; 
    
	//MOTOR CONT.
    public static final int leftFrontDriveChannel = 5; 
    public static final int leftRearDriveChannel = 6; 
    public static final int rightFrontDriveChannel = 8;
    public static final int rightRearDriveChannel = 7; 
    public static final int frontLoaderChannel = 2; 
    public static final int backLoaderChannel = 1; 
    public static final int basketChannel = 9;
    
	//PNEUMATICS
    public static final int launchSolenoidChannel = 0;
    public static final int compressorChannel = 0;
    public static final int armSolenoidTopForward = 1;
    public static final int armSolenoidTopReverse = 2;
    public static final int armSolenoidDownForward = 3;
    public static final int armSolenoidDownReverse = 4;
    
    //ENCODER
    public static final int encoderA = 4;
    public static final int encoderB = 3;
    
    //CAMERA
    public static final String frontCamera = "cam0";
    public static final String rearCamera = "cam1";
}
