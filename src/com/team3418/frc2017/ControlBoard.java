package com.team3418.frc2017;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A basic framework for the control board Like the drive code, one instance of
 * the ControlBoard object is created upon startup, then other methods request
 * the singleton ControlBoard instance.
 */
public class ControlBoard {
    private static ControlBoard mInstance = new ControlBoard();

    public static ControlBoard getInstance() {
        return mInstance;
    }
    
    //create joystick object
    private final Joystick mDriverStick;
    private final Joystick mSecondaryDriverStick;
    
    
    private final double mStickDeadzone = .15;
    
    //initialize joystick objects
    ControlBoard() {
    	mSecondaryDriverStick =  new Joystick(1);
        mDriverStick = new Joystick(0);
    }
    
    
    
    // return button / axis info
    // EXAMPLES
    /*
    
    public double getThrottle() {
        return -mDriverStick.getY();
    }
    
    public double getTurn() {
        return mOperatorStick.getX();
    }
    
    public double getExclusiveOptions() {
        if (mOtherThingie.getRawButton(11)) {
            return 1.0;
        } else if (mOtherThingie.getRawButton(12)) {
            return -1.0;
        } else {
            return 0.0;
        }
    }
    
    public boolean getRawAxisGreaterThan() {
        return mOtherThingie.getRawAxis(3) > 0.1;
    }
    
    public boolean getRawAxisLessThan() {
        return mOtherThingie.getRawAxis(2) < -0.1;
    }
    
    public boolean getButtonCombo() {
        return mOtherThingie.getRawButton(1) && mOtherThingie.getRawButton(2);
    }
    
    */
    
    
    // DRIVER CONTROLS (mDriverStick)
    public double getLeftThrottle() {
        return -mDriverStick.getRawAxis(1);
    }
    public double getRightThrottle() {
    	return -mDriverStick.getRawAxis(5);
    }
    
    public double getClimberForwardThrottle(){
    	return mDriverStick.getRawAxis(3);
    }
    
    public double getClimberBackwardThrottle(){
    	return -mDriverStick.getRawAxis(2);
    }
    
    public int getPov(){
    	System.out.println(mDriverStick.getPOV(0));
    	return mDriverStick.getPOV(0);
    }
    
    
    
    
}
