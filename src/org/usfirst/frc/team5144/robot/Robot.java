
package org.usfirst.frc.team5144.robot;

<<<<<<< HEAD
import org.usfirst.frc.team5144.robot.commands.AutoBasket;
import org.usfirst.frc.team5144.robot.commands.AutoDriveAndShoot;
import org.usfirst.frc.team5144.robot.commands.AutoPickUpBallAndShoot;
import org.usfirst.frc.team5144.robot.commands.AutoShoot;
import org.usfirst.frc.team5144.robot.commands.DriveForward;
import org.usfirst.frc.team5144.robot.subsystems.Basket;
=======
import org.usfirst.frc.team5144.robot.commands.DriveForward;
import org.usfirst.frc.team5144.robot.subsystems.Basket;
import org.usfirst.frc.team5144.robot.subsystems.Camera;
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
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

	public static OI oi;
	public static DriveTrain drivetrain;
	public static Shooter shooter;
	public static Basket basket;
<<<<<<< HEAD
	//public static Camera camera;
=======
	public static Camera camera;
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
	public static Pneumatics pneumatics;

    Command autonomousCommand;
    SendableChooser chooser;

<<<<<<< HEAD
=======
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
    public void robotInit() {
    	pneumatics = new Pneumatics();
    	drivetrain = new DriveTrain();
    	shooter = new Shooter();
    	basket = new Basket();
<<<<<<< HEAD
    	//camera = new Camera();
=======
    	camera = new Camera();
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
		oi = new OI();
		
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new WaitCommand(0));
<<<<<<< HEAD
        chooser.addObject("Test", new AutoBasket(2.4, .5));
        chooser.addObject("Drive Auto", new DriveForward(2, .5));
        chooser.addObject("Auto Shoot", new AutoShoot());
        chooser.addObject("Drive and Shoot", new AutoDriveAndShoot());
        chooser.addObject("Pick up and Shoot", new AutoPickUpBallAndShoot());
        //chooser.addObject("Auto Line", new DriveForward(1.5, .75));
=======
        chooser.addObject("Drive Auto", new DriveForward(2, .5));
        chooser.addObject("Auto Line", new DriveForward(1.5, .75));
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
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
<<<<<<< HEAD
        //Robot.camera.startVision();
        log();
=======
        Robot.camera.startVision();
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void log(){
    	drivetrain.log();
<<<<<<< HEAD
    	//shooter.log();
    	//basket.log();
=======
    	shooter.log();
    	basket.log();
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
    }
}
