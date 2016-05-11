package org.usfirst.frc.team5144.robot;

import org.usfirst.frc.team5144.robot.commands.ArmSolenoidDownForward;
import org.usfirst.frc.team5144.robot.commands.ArmSolenoidDownReverse;
import org.usfirst.frc.team5144.robot.commands.ArmSolenoidTopForward;
import org.usfirst.frc.team5144.robot.commands.ArmSolenoidTopReverse;
import org.usfirst.frc.team5144.robot.commands.LaunchSolenoid;
import org.usfirst.frc.team5144.robot.commands.ShooterWheelsIn;
import org.usfirst.frc.team5144.robot.commands.ShooterWheelsOut;
import org.usfirst.frc.team5144.robot.commands.StartCamera1;
import org.usfirst.frc.team5144.robot.commands.StartCamera2;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	/**Create the joysticks with the port numbers form RobotMap */
	private Joystick leftJoystick = new Joystick(RobotMap.joystickLeftChannel);
    private Joystick rightJoystick = new Joystick(RobotMap.joystickRightChannel);
    private Joystick xboxController = new Joystick(RobotMap.xboxControllerChannel);
    
    //Right Joystick
    /**Create buttons on the joystick that will be used to call commands*/
    private Button rightDriveTrigger = new JoystickButton(rightJoystick, 1);
    private Button rightDriveStick2 = new JoystickButton(rightJoystick, 2);
    private Button rightDriveStick3 = new JoystickButton(rightJoystick, 3);
    private Button rightDriveStick4 = new JoystickButton(rightJoystick, 4);
    private Button rightDriveStick5 = new JoystickButton(rightJoystick, 5);
    private Button rightDriveStick6 = new JoystickButton(rightJoystick, 6);
    private Button rightDriveStick11 = new JoystickButton(rightJoystick, 11);
    private Button rightDriveStick12 = new JoystickButton(rightJoystick, 12);
    
    //Xbox controller
    /**Create buttons on the xbox controller that will be used to call commands*/
    private Button xboxA = new JoystickButton(xboxController, 1); //A button
    //private Button xboxB = new JoystickButton(xboxController, 2); //B button
    private Button xboxX = new JoystickButton(xboxController, 3); //X button
    private Button xboxY = new JoystickButton(xboxController, 4); //Y button
    private Button xboxRB = new JoystickButton(xboxController, 6); //Right Bumper
    private Button xboxLB = new JoystickButton(xboxController, 5); //Left Bumper
    //private double xboxLX = xboxController.getRawAxis(0); //Left joystick x-axis
    //private double xboxLY = xboxController.getRawAxis(1); //Left joystick y-axis
    //private double xboxRX = xboxController.getRawAxis(4); //Right joystick x-axis
    private double xboxRY = xboxController.getRawAxis(5); //Right joystick y-axis
    //private double xboxLT = xboxController.getRawAxis(2); //Left trigger
    //private double xboxRT = xboxController.getRawAxis(3); //Right trigger
    
    public OI(){
    	/**Commands called based on changes in the state of the buttons*/
       	xboxRB.whileHeld(new ShooterWheelsOut());
    	xboxLB.whileHeld(new ShooterWheelsIn());
    	xboxA.whileHeld(new LaunchSolenoid());
    	rightDriveStick3.whileHeld(new ArmSolenoidTopForward());
    	rightDriveStick5.whileHeld(new ArmSolenoidTopReverse());
    	rightDriveStick6.whileHeld(new ArmSolenoidDownForward());
    	rightDriveStick4.whileHeld(new ArmSolenoidDownReverse());
    	rightDriveStick11.whenPressed(new StartCamera1());
    	rightDriveStick12.whenPressed(new StartCamera2());    	
    }
    
    /**
     * Accesses the joystick assinged to the left spot
     * @return the left joystick
     */
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }
    
    /**
     * Accesses the joystick assigned to the right spot
     * @return the right joystick
     */
    public Joystick getRightJoystick() {
    	return rightJoystick;
    }
    
    /**
     * Accesses the xbox controller in the port assigned
     * @return the xbox controller
     */
    public Joystick getXboxController() {
    	return xboxController;
    }
    
    /**
     * Gets the value of the xbox controller and will output 0 if the
     * output is under .25
     * @return the value of the right y-axis on the xbox controller
     */
    public double getXboxLeftJoystickYAxis(){
    	if(Math.abs(Robot.oi.xboxRY) < .25)
    		return 0;
    	else
    		return Robot.oi.xboxRY;
    }
    
}