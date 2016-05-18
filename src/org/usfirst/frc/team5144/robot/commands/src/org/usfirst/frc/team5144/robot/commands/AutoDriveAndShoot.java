package org.usfirst.frc.team5144.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveAndShoot extends CommandGroup {
    
    public  AutoDriveAndShoot() {
        addSequential(new DriveForward(1.5, -.75));
        addSequential(new AutoShoot());
    }
}
