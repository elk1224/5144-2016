package org.usfirst.frc.team5144.robot.subsystems;

import org.usfirst.frc.team5144.robot.RobotMap;
import org.usfirst.frc.team5144.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController leftFrontDrive, leftRearDrive, rightFrontDrive, rightRearDrive;
	private RobotDrive drive;

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
    }
    
    public void log(){
    	
    }
}

