package org.usfirst.frc.team5144.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team5144.robot.RobotMap;
<<<<<<< HEAD
import org.usfirst.frc.team5144.robot.commands.BasketWithJoystick;
=======
>>>>>>> ee061f373fe5d47e6ff8e154a523c383d06a3796

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Basket extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController basketDrive;
	private DigitalInput limitBack, limitFront;
	private Encoder encoder;
	
	public Basket(){
		basketDrive = new Talon(RobotMap.basketChannel);
		limitFront = new DigitalInput(RobotMap.limitFrontChannel);
		limitBack = new DigitalInput(RobotMap.limitBackChannel);
		encoder = new Encoder(RobotMap.encoderA, RobotMap.encoderB, true, EncodingType.k4X);
		encoder.setDistancePerPulse(1.0/1.31);
	}

	public void initDefaultCommand() {
<<<<<<< HEAD
		setDefaultCommand(new BasketWithJoystick());
=======
>>>>>>> ee061f373fe5d47e6ff8e154a523c383d06a3796
    }
	
	public void basket(double speed){
		basketDrive.set(speed);
	}
	
	public void stop(){
		basketDrive.set(0);
	}
	
	public boolean getFrontLimit(){
		return limitFront.get();
	}
	
	public boolean getBackLimit(){
		return limitBack.get();
	}
	
	public int getEncoder(){
		return encoder.get();
	}
	
	public void log(){
		SmartDashboard.putNumber("Encoder Distance", encoder.get()/90.0554);		    	
	}
}

