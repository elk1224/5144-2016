package org.usfirst.frc.team5144.robot.commands;

import org.usfirst.frc.team5144.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLaunchSolenoid extends Command {
	
	private double time;

    public AutoLaunchSolenoid(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pneumatics.LaunchSolenoidOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pneumatics.LaunchSolenoidOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
