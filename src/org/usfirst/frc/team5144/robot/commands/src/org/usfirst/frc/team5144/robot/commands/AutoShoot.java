package org.usfirst.frc.team5144.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShoot extends CommandGroup {
    
    public  AutoShoot() {
        addSequential(new AutoShooterWheelsOut(1.5));
        addParallel(new AutoShooterWheelsOut(1.5));
        addSequential(new AutoLaunchSolenoid(1));
    }
}
