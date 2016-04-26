
package org.usfirst.frc.team5144.robot;

import org.usfirst.frc.team5144.robot.commands.DriveForward;
import org.usfirst.frc.team5144.robot.subsystems.Basket;
import org.usfirst.frc.team5144.robot.subsystems.Camera;
import org.usfirst.frc.team5144.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5144.robot.subsystems.Pneumatics;
import org.usfirst.frc.team5144.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//This it robit
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Shooter shooter;
	public static Basket basket;
	public static Camera camera;
	public static Pneumatics pneumatics;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	drivetrain = new DriveTrain();
    	shooter = new Shooter();
    	basket = new Basket();
    	camera = new Camera();
    	pneumatics = new Pneumatics();
		oi = new OI();
		
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new WaitCommand(0));
        chooser.addObject("Drive Auto", new DriveForward(2, .5));
        chooser.addObject("Auto Line", new DriveForward(1.5, .75));
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Robot.camera.startVision();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void log(){
    	drivetrain.log();
    	shooter.log();
    	basket.log();
    }
}
