package org.usfirst.frc.team5144.robot;

import org.usfirst.frc.team5144.robot.commands.StartCamera1;
import org.usfirst.frc.team5144.robot.commands.StartCamera2;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick leftJoystick = new Joystick(RobotMap.joystickLeftChannel);
    private Joystick rightJoystick = new Joystick(RobotMap.joystickRightChannel);
    private Joystick xboxController = new Joystick(RobotMap.xboxControllerChannel);
    //Not sure if it is correct to put diff axis here and then use an accessor to pull them for commands
    //private double driveStickY = rightJoystick.getY();
    //private double driveStickX = rightJoystick.getX();
   // private boolean driveTrigger = rightJoystick.getRawButton(1);
    private Button driveStick2 = new JoystickButton(rightJoystick, 2); //Button 2 on the driveJoystick
    private Button driveStick3 = new JoystickButton(rightJoystick, 3);
    //private double sens = (-rightJoystick.getZ() + 1) / 2.0; //Sets the sensitivity of the drive joystick
    //Xbox controller
    //private Button xboxA = new JoystickButton(xboxController, 1); //A button
    //private Button xboxB = new JoystickButton(xboxController, 2); //B button
    //private Button xboxX = new JoystickButton(xboxController, 3); //X button
    //private Button xboxY = new JoystickButton(xboxController, 4); //Y button
    //private Button xboxRB = new JoystickButton(xboxController, 6); //Right Bumper
    //private Button xboxLB = new JoystickButton(xboxController, 5); //Left Bumper
    //private double xboxLX = xboxController.getRawAxis(0); //Left joystick x-axis
    private double xboxLY = xboxController.getRawAxis(1); //Left joystick y-axis
    //private double xboxRX = xboxController.getRawAxis(4); //Right joystick x-axis
    //private double xboxRY = xboxController.getRawAxis(5); //Right joystick y-axis
    //private Button xboxStart = new JoystickButton(xboxController, 9); //Start button
    //private double xboxLT = xboxController.getRawAxis(2); //Left trigger //check axis number
    //private double xboxRT = xboxController.getRawAxis(3); //Right trigger //check axis number
    
    public OI(){
    	driveStick2.whenPressed(new StartCamera1());
    	driveStick3.whenPressed(new StartCamera2());
    }
    
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }
    
    public Joystick getRightJoystick() {
    	return rightJoystick;
    }
    
    public Joystick getXboxController() {
    	return xboxController;
    }
    //Create deadzone?
    public double getXboxLeftJoystickYAxis(){
    	return deadZone(xboxLY);
    }
    
    public double deadZone(double xboxAxis){
    	if(Math.abs(xboxAxis) <= .25)
			xboxAxis = 0.0;
    	return xboxAxis;
    }
}
