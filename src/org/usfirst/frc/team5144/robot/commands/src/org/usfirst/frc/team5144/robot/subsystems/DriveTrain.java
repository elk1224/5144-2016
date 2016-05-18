package org.usfirst.frc.team5144.robot.subsystems;

import org.usfirst.frc.team5144.robot.Robot;
import org.usfirst.frc.team5144.robot.RobotMap;
import org.usfirst.frc.team5144.robot.commands.DriveWithJoysticks;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	//Define the components that are only needed for this subsystem
	private SpeedController leftFrontDrive, leftRearDrive, rightFrontDrive, rightRearDrive;
	private RobotDrive drive;
	private AnalogInput ultrasonic;
	
	//Move NAVX to its own separate subsystem with the commands
	//pertaining to the subsystem in their own package
	//NAVX
	private AHRS ahrs; 
	
	/**Define the command that the subsystem will default
	 * to if it the subsystem is not being called by another command*/
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    /**Construct the components that will be used in the subsystem*/
    public DriveTrain(){
    	super();
    	leftFrontDrive = new Talon(RobotMap.leftFrontDriveChannel);
    	leftRearDrive = new Talon(RobotMap.leftRearDriveChannel);
    	rightFrontDrive = new Talon(RobotMap.rightFrontDriveChannel);
    	rightRearDrive = new Talon(RobotMap.rightRearDriveChannel);
    	drive = new RobotDrive(leftFrontDrive, leftRearDrive, rightFrontDrive, rightRearDrive);
    	ultrasonic = new AnalogInput(RobotMap.ultrasonicChannel);    	
    	ahrs = new AHRS(SerialPort.Port.kUSB);
    }
    
    public AHRS getNAVX(){
    	return ahrs;
    }
    
    /**
     * 
     * @param forward
     * @param rotate
     */
    public void drive(double forward, double rotate){
    	drive.arcadeDrive(-forward, -rotate);
    }
    //Check for flips
    /**
     * Runs the drive as arcade drive based on input from
     * the joystick used in the function
     * @param joy Joystick for the drive
     */
    public void drive(Joystick joy){
    	drive.arcadeDrive(joy);
    }
    
    /**
     * Stops the robot
     */
    public void stop(){
    	drive.arcadeDrive(0, 0);
    }
    //Update with conversion
    public double getDistance(){
    	return ultrasonic.getVoltage();
    }   
    
    /**Output information to the smartdashboard*/
    public void log(){
    	SmartDashboard.putBoolean(  "IMU_Connected",        ahrs.isConnected());
        SmartDashboard.putBoolean(  "IMU_IsCalibrating",    ahrs.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
        SmartDashboard.putNumber(   "IMU_Pitch",            ahrs.getPitch());
        SmartDashboard.putNumber(   "IMU_Roll",             ahrs.getRoll());
    	
    }
}