package org.usfirst.frc.team5144.robot.subsystems;

import org.usfirst.frc.team5144.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController frontLoader, backLoader;

    public void initDefaultCommand() {
    }
    
    public Shooter() {
		frontLoader = new Talon(RobotMap.frontLoaderChannel);
		backLoader = new Talon(RobotMap.backLoaderChannel);
	}
    
    public void shooterOut(double speed){
    	frontLoader.set(speed);
    	backLoader.set(-speed);
    }
    
    public void shooterIn(double speed){
    	frontLoader.set(-speed);
    	backLoader.set(speed);
    }
    
    public void log(){
    	SmartDashboard.putData(getCurrentCommand());
    }
}

