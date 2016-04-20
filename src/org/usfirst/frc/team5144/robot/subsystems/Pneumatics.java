package org.usfirst.frc.team5144.robot.subsystems;

import org.usfirst.frc.team5144.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Compressor c;
	private Solenoid launchSolenoid;
	private DoubleSolenoid armSolenoidTop, armSolenoidDown;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Pneumatics(){
    	c = new Compressor(RobotMap.compressorChannel);
    	c.setClosedLoopControl(true);
    	launchSolenoid = new Solenoid(RobotMap.launchSolenoidChannel);
    	armSolenoidTop = new DoubleSolenoid(RobotMap.armSolenoidTopForward, RobotMap.armSolenoidTopReverse);
    	armSolenoidDown = new DoubleSolenoid(RobotMap.armSolenoidDownForward, RobotMap.armSolenoidDownReverse);
    }
    
    public void LaunchSolenoidOn(){
    	launchSolenoid.set(true);
    }
    
    public void LaunchSolenoidOff(){
    	launchSolenoid.set(false);
    }
    
    public void CompressorLog(){
		SmartDashboard.putBoolean("Comp Enabled", c.enabled());
    	SmartDashboard.putBoolean("Comp Pressure Switch", c.getPressureSwitchValue());
    	SmartDashboard.putNumber("Comp Current", c.getCompressorCurrent());
    	SmartDashboard.putBoolean("Pressure Switch Value", c.getPressureSwitchValue());
    }
    
    public void log(){
    	CompressorLog();
    }
    
}

