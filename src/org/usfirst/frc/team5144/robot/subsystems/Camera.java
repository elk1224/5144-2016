package org.usfirst.frc.team5144.robot.subsystems;

import org.usfirst.frc.team5144.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	int session;
	Image frame;
	int session2;
	Image frame2;
	int currSession;
	CameraServer server;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Constructs the camera object, 
     * creates a frame that will hold the images from the camera,
     * creates a session for each of the two cameras,
     * sets the current session to the first session,
     * and starts to grab images from the first session
     */
    public Camera(){
    	super();
        this.frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        this.session = NIVision.IMAQdxOpenCamera(RobotMap.frontCamera,
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //NIVision.IMAQdxConfigureGrab(session);
        
        this.session2 = NIVision.IMAQdxOpenCamera(RobotMap.rearCamera,
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        //NIVision.IMAQdxConfigureGrab(session2);
        this.currSession = this.session;
        NIVision.IMAQdxConfigureGrab(this.currSession);
    }
    
    /**
     * Starts grabbing the frames from the camera assigned to the
     * current session
     */
    public void startVision(){
        NIVision.IMAQdxGrab(this.currSession, this.frame, 1);
        CameraServer.getInstance().setImage(this.frame);
    }
    
    /**
     * Stops pulling the current session,
     * changes the current session to the first session, 
     * and runs the current session
     */
    public void setCamera1(){
    	NIVision.IMAQdxStopAcquisition(this.currSession);
 		this.currSession = this.session;
        NIVision.IMAQdxConfigureGrab(this.currSession);
    }
    
    /**
     * Stops pulling the current session,
     * changes the current session to the second session,
     * and runs the current session
     */
    public void setCamera2(){
    	NIVision.IMAQdxStopAcquisition(this.currSession);
 		this.currSession = this.session2;
 		NIVision.IMAQdxConfigureGrab(this.currSession);
    }
}

