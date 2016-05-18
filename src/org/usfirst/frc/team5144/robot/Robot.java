
package org.usfirst.frc.team5144.robot;

import org.usfirst.frc.team5144.robot.commands.AutoCenterDrive;
import org.usfirst.frc.team5144.robot.commands.AutoDriveAndShoot;
import org.usfirst.frc.team5144.robot.commands.AutoPickUpBallAndShoot;
import org.usfirst.frc.team5144.robot.commands.AutoShoot;
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

	/**Define the subsystems*/
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Shooter shooter;
	public static Basket basket;
	public static Camera camera;
	public static Pneumatics pneumatics;
	
	/**Create the command and the selection dialog
	 * for autonomous*/
    Command autonomousCommand;
    SendableChooser chooser;
    
    /**called once each time the robot starts up*/
    public void robotInit() {
    	/**Construct the subsystems*/
    	pneumatics = new Pneumatics();
    	drivetrain = new DriveTrain();
    	shooter = new Shooter();
    	basket = new Basket();
    	camera = new Camera();
    	//Make sure OI is constructed after any subsystems that require button
    	//input or else the program will crash
		oi = new OI();
		
		/**Construct the dialog for the dashboard and add options that
		 * are assigned to commands that will be called when autonomous starts*/
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new WaitCommand(0));
        //chooser.addObject("Test", new AutoBasket(2.4, .5));
        chooser.addObject("Drive Auto", new DriveForward(2, .5));
        chooser.addObject("Auto Shoot", new AutoShoot());
        chooser.addObject("Drive and Shoot", new AutoDriveAndShoot());
        chooser.addObject("Pick up and Shoot", new AutoPickUpBallAndShoot());
        chooser.addObject("Center Drive Test", new AutoCenterDrive(5));
        chooser.addObject("Anti-center drive", new DriveForward(5, -.75));
        //chooser.addObject("Auto Line", new DriveForward(1.5, .75));
        SmartDashboard.putData("Auto mode", chooser);
        
        Robot.drivetrain.getNAVX().zeroYaw();
    }
	
	/**called once each time the robot enters Disabled mode*/
    public void disabledInit(){

    }
	
    /**called periodically while the robot is in Disabled mode*/
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//Start the camera server and create the frames for
		//the dashboard and start the first camera
		Robot.camera.startVision();
		Robot.camera.setCamera1();
		log();
	}
	
	/**called once each time the robot enters Autonomous mode*/
    public void autonomousInit() {
    	//Sets the autonomous command to the command selected from the dashboard
        autonomousCommand = (Command) chooser.getSelected();
        //Starts the command if a selection has been made
        if (autonomousCommand != null) autonomousCommand.start();
        Robot.drivetrain.getNAVX().zeroYaw();
    }

    /**called periodically while the robot is in Autonomous mode*/
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    /**called once each time the robot enters TeleOperated mode*/
    public void teleopInit() {
		//Stops the command from Autonomous mode if it is stil running
        if (autonomousCommand != null) autonomousCommand.cancel();
        Robot.drivetrain.getNAVX().zeroYaw();
        log();
    }

    /**called periodically while the robot is in TeleOperated mode*/
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Robot.camera.startVision();
        log();
    }
    
    /**called periodically while the robot is in test mode*/
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /**display driverstation information from the subsystems*/
    public void log(){
    	drivetrain.log();
    	//shooter.log();
    	//basket.log();
    }
}
