package org.usfirst.frc.team5144.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team5144.robot.RobotMap;
import org.usfirst.frc.team5144.robot.commands.BasketWithJoystick;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem for controlling the basket
 */
public class Basket extends Subsystem {
	
	//Define the components that are only needed for this subsystem
	private SpeedController basketDrive;
	private DigitalInput limitBack, limitFront;
	private Encoder encoder;
	
	/**Define the command that the subsystem will default
	 * to if it the subsystem is not being called by another command*/
	public void initDefaultCommand() {
		setDefaultCommand(new BasketWithJoystick());
    }
	
	/**Construct the components that will be used in the subsystem*/
	public Basket(){
		basketDrive = new Talon(RobotMap.basketChannel);
		limitFront = new DigitalInput(RobotMap.limitFrontChannel);
		limitBack = new DigitalInput(RobotMap.limitBackChannel);
		encoder = new Encoder(RobotMap.encoderA, RobotMap.encoderB, true, EncodingType.k4X);
		encoder.setDistancePerPulse(1.0/1.31);
	}
	
	/**
	 * Sets the speed of the basket to the input
	 * @param speed
	 */
	public void basket(double speed){
		basketDrive.set(speed);
	}
	
	/**Stops the basket*/
	public void stop(){
		basketDrive.set(0);
	}
	
	/**
	 * Gets the state of the limit switch on the front
	 * side of the robot
	 * @return state of the switch
	 */
	public boolean getFrontLimit(){
		return limitFront.get();
	}
	
	/**
	 * Gets the state of the limit switch on the back
	 * side of the robot
	 * @return state of the switch
	 */
	public boolean getBackLimit(){
		return limitBack.get();
	}
	
	/**
	 * Gets the current reading on the encoder
	 * @return output in volts
	 */
	public int getEncoder(){
		return encoder.get();
	}
	
	/**Output information to the smartdashboard*/
	public void log(){
		SmartDashboard.putNumber("Encoder Distance", encoder.get()/90.0554);		    	
	}
}