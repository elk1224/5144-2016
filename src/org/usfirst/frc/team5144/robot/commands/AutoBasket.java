package org.usfirst.frc.team5144.robot.commands;

import org.usfirst.frc.team5144.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoBasket extends Command {
	
	private double time, speed;

    public AutoBasket(double time, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.basket);
    	this.time = time;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.basket.basket(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.basket.basket(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
