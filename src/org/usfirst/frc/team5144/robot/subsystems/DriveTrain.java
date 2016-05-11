package org.usfirst.frc.team5144.robot.subsystems;

<<<<<<< HEAD
=======
import java.io.PipedWriter;

>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
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
<<<<<<< HEAD
import edu.wpi.first.wpilibj.SerialPort;
=======
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController leftFrontDrive, leftRearDrive, rightFrontDrive, rightRearDrive;
	private RobotDrive drive;
	private AnalogInput ultrasonic;
	
	//Move NAVX to its own separate subsystem with the commands
	//pertaining to the subsystem in their own package
	//NAVX
<<<<<<< HEAD
	//private AHRS ahrs; 
	
=======
	private AHRS ahrs;    
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
 
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    public DriveTrain(){
    	super();
    	leftFrontDrive = new Talon(RobotMap.leftFrontDriveChannel);
    	leftRearDrive = new Talon(RobotMap.leftRearDriveChannel);
    	rightFrontDrive = new Talon(RobotMap.rightFrontDriveChannel);
    	rightRearDrive = new Talon(RobotMap.rightRearDriveChannel);
    	drive = new RobotDrive(leftFrontDrive, leftRearDrive, rightFrontDrive, rightRearDrive);
<<<<<<< HEAD
    	ultrasonic = new AnalogInput(RobotMap.ultrasonicChannel);    	
    	//ahrs = new AHRS(SerialPort.Port.kUSB);
    }

    public void drive(double forward, double rotate){
    	drive.arcadeDrive(-forward, -rotate);
    }
    //Check for flips
    public void drive(Joystick joy){
    	drive.arcadeDrive(joy);
    }
    
    public void stop(){
    	drive.arcadeDrive(0, 0);
=======
    	ultrasonic = new AnalogInput(RobotMap.ultrasonicChannel);
    	
    	ahrs = new AHRS(SPI.Port.kMXP);
    }

    public void drive(double left, double right){
    	drive.arcadeDrive(-left, -right);
    }
    //Check for flips
    public void drive(Joystick joyL, Joystick joyR){
    	drive.tankDrive(joyL, joyR);
    }
    
    public void stop(){
    	drive.tankDrive(0, 0);
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
    }
    //Update with conversion
    public double getDistance(){
    	return ultrasonic.getVoltage();
<<<<<<< HEAD
    }   
    
    public void log(){
    }
}
=======
    }
    //Remove?
    public AHRS getNAVX(){
    	return ahrs;
    }
    //Remove
    public void ahrsLog(){
    	/* Display 6-axis Processed Angle Data                                      */
        SmartDashboard.putBoolean(  "IMU_Connected",        ahrs.isConnected());
        SmartDashboard.putBoolean(  "IMU_IsCalibrating",    ahrs.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
        SmartDashboard.putNumber(   "IMU_Pitch",            ahrs.getPitch());
        SmartDashboard.putNumber(   "IMU_Roll",             ahrs.getRoll());
        
        /* Display tilt-corrected, Magnetometer-based heading (requires             */
        /* magnetometer calibration to be useful)                                   */
        
        SmartDashboard.putNumber(   "IMU_CompassHeading",   ahrs.getCompassHeading());
        
        /* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
        SmartDashboard.putNumber(   "IMU_FusedHeading",     ahrs.getFusedHeading());

        /* These functions are compatible w/the WPI Gyro Class, providing a simple  */
        /* path for upgrading from the Kit-of-Parts gyro to the navx MXP            */
        
        SmartDashboard.putNumber(   "IMU_TotalYaw",         ahrs.getAngle());
        SmartDashboard.putNumber(   "IMU_YawRateDPS",       ahrs.getRate());

        /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
        
        SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
        SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
        SmartDashboard.putBoolean(  "IMU_IsMoving",         ahrs.isMoving());
        SmartDashboard.putBoolean(  "IMU_IsRotating",       ahrs.isRotating());

        /* Display estimates of velocity/displacement.  Note that these values are  */
        /* not expected to be accurate enough for estimating robot position on a    */
        /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
        /* of these errors due to single (velocity) integration and especially      */
        /* double (displacement) integration.                                       */
        
        SmartDashboard.putNumber(   "Velocity_X",           ahrs.getVelocityX());
        SmartDashboard.putNumber(   "Velocity_Y",           ahrs.getVelocityY());
        SmartDashboard.putNumber(   "Displacement_X",       ahrs.getDisplacementX());
        SmartDashboard.putNumber(   "Displacement_Y",       ahrs.getDisplacementY());
        
        /* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
        /* NOTE:  These values are not normally necessary, but are made available   */
        /* for advanced users.  Before using this data, please consider whether     */
        /* the processed data (see above) will suit your needs.                     */
        
        SmartDashboard.putNumber(   "RawGyro_X",            ahrs.getRawGyroX());
        SmartDashboard.putNumber(   "RawGyro_Y",            ahrs.getRawGyroY());
        SmartDashboard.putNumber(   "RawGyro_Z",            ahrs.getRawGyroZ());
        SmartDashboard.putNumber(   "RawAccel_X",           ahrs.getRawAccelX());
        SmartDashboard.putNumber(   "RawAccel_Y",           ahrs.getRawAccelY());
        SmartDashboard.putNumber(   "RawAccel_Z",           ahrs.getRawAccelZ());
        SmartDashboard.putNumber(   "RawMag_X",             ahrs.getRawMagX());
        SmartDashboard.putNumber(   "RawMag_Y",             ahrs.getRawMagY());
        SmartDashboard.putNumber(   "RawMag_Z",             ahrs.getRawMagZ());
        SmartDashboard.putNumber(   "IMU_Temp_C",           ahrs.getTempC());
        
        /* Omnimount Yaw Axis Information                                           */
        /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
        AHRS.BoardYawAxis yaw_axis = ahrs.getBoardYawAxis();
        SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
        SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
        
        /* Sensor Board Information                                                 */
        SmartDashboard.putString(   "FirmwareVersion",      ahrs.getFirmwareVersion());
        
        /* Quaternion Data                                                          */
        /* Quaternions are fascinating, and are the most compact representation of  */
        /* orientation data.  All of the Yaw, Pitch and Roll Values can be derived  */
        /* from the Quaternions.  If interested in motion processing, knowledge of  */
        /* Quaternions is highly recommended.                                       */
        SmartDashboard.putNumber(   "QuaternionW",          ahrs.getQuaternionW());
        SmartDashboard.putNumber(   "QuaternionX",          ahrs.getQuaternionX());
        SmartDashboard.putNumber(   "QuaternionY",          ahrs.getQuaternionY());
        SmartDashboard.putNumber(   "QuaternionZ",          ahrs.getQuaternionZ());
        
        /* Sensor Data Timestamp */
        SmartDashboard.putNumber(   "SensorTimestamp",		ahrs.getLastSensorTimestamp());
        
        /* Connectivity Debugging Support                                           */
        SmartDashboard.putNumber(   "IMU_Byte_Count",       ahrs.getByteCount());
        SmartDashboard.putNumber(   "IMU_Update_Count",     ahrs.getUpdateCount());
    }
    
    public void log(){
    	ahrsLog();
    }
}

>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
