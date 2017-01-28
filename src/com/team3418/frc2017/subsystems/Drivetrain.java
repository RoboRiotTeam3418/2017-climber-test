package com.team3418.frc2017.subsystems;

import com.team3418.frc2017.Constants;

import edu.wpi.first.wpilibj.RobotDrive;


public class Drivetrain extends Subsystem {
	
	
	static Drivetrain mInstance = new Drivetrain();

    public static Drivetrain getInstance() {
        return mInstance;
    }
    
    RobotDrive mDrive = new RobotDrive(Constants.kLeftMotorPWMID, Constants.kRightMotorPWMID);
	
	
    public void setTankDriveSpeed(double left, double right){
    	mDrive.tankDrive(left, right);
    }
    
    public void setArcadeDriveSpeed(double move, double rotate){
    	mDrive.arcadeDrive(move, rotate);
    }
    
    public void setPovDrive(){
    	
    }
	
    
    
    
	
	
	@Override
	public void updateSubsystemState() {
		
	}

	@Override
	public void outputToSmartDashboard() {
		
	}
	
}
