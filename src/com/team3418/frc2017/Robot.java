package com.team3418.frc2017;

// import classes used in main robot program
import com.team3418.frc2017.Constants;
import com.team3418.frc2017.subsystems.Climber;
import com.team3418.frc2017.subsystems.Drivetrain;
import com.team3418.frc2017.vision.Pipeline;
import com.team3418.frc2017.vision.Vision;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 * The main robot class, which instantiates all robot parts and helper classes.
 * After initializing all robot parts, the code sets up the autonomous.
 */
public class Robot extends IterativeRobot {
    // Subsystems
	Climber mClimber = Climber.getInstance();
	Drivetrain mDrivetrain = Drivetrain.getInstance();
	
    // Other parts of the robot
    ControlBoard mControls = ControlBoard.getInstance();
    //Vision mVision;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    
    private void stopAllSubsystems(){
    	mClimber.stop();
	}
    
    private void updateAllSubsystems() {
    	mClimber.updateSubsystemState();
    	//mVision.output();
    }
    
    
    @Override
    public void robotInit() {
    	//set initial wanted states for all subsystems
    	
        //mVision = Vision.getInstance();

    	stopAllSubsystems();
    	updateAllSubsystems();
    }
    
    @Override
    public void disabledInit() {
    	stopAllSubsystems();
    	updateAllSubsystems();
    }
    
    @Override
    public void autonomousInit() {
    	stopAllSubsystems();
    	updateAllSubsystems();
    }
    
    @Override
    public void teleopInit() {
    	//set subsystems to state wanted at beginning of teleop
    	stopAllSubsystems();
    	updateAllSubsystems();
    	}
    
    @Override
    public void disabledPeriodic() {
    	
    }
    
    @Override
    public void teleopPeriodic() {
    	//set states of subsystems depending on operator controls or the state of other subsystems
    	    	
    	if (mControls.getClimberBackwardThrottle() < 0 || mControls.getClimberForwardThrottle() > 0) {
    		mClimber.setSpeed(mControls.getClimberBackwardThrottle() + mControls.getClimberForwardThrottle());
    	} else {
    		mClimber.stop();
    	}
    	
    	
    	    	
    	// simple drive control
    	mDrivetrain.setTankDriveSpeed(mControls.getLeftThrottle(), mControls.getRightThrottle());
    	//mDrivetrain.setArcadeDriveSpeed(, );


    	// update subsystem states
    	updateAllSubsystems();
    	//
    }
    
    @Override
    public void autonomousPeriodic() {
    	
    }
    
    
    /*
    private void updateDriverFeedback() {
    	
    }
    */
}
