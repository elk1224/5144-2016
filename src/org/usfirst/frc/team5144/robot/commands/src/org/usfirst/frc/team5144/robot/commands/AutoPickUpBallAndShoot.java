package org.usfirst.frc.team5144.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPickUpBallAndShoot extends CommandGroup {
    
    public  AutoPickUpBallAndShoot() {
    	//addParallel(new AutoBasket(2.4, -.5));
    	addParallel(new DriveForward(2, -.75));
    	addSequential(new WaitCommand(1));
        addParallel(new AutoShooterWheelsIn(2));
        addSequential(new WaitCommand(1));
        addParallel(new AutoBasket(2.4, .5));
        addSequential(new DriveForward(2, .75));
        addSequential(new AutoShoot());
    }
}
