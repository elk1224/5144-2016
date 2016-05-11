package org.usfirst.frc.team5144.robot.commands;

import org.usfirst.frc.team5144.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {
	private double time, speed;
	
    public DriveForward(double time, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	this.time = time;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
<<<<<<< HEAD
    	Robot.drivetrain.drive(speed, 0);
=======
    	Robot.drivetrain.drive(speed, speed);
>>>>>>> 93b87c528ea2c63f3787595ddb1b51170db0597b
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
