package org.usfirst.frc.team3473.robot;

import org.usfirst.frc.team3473.robot.commands.CommandList;
import org.usfirst.frc.team3473.robot.subsystems.SubsystemList;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * @author Forest 
 */
public class Robot extends IterativeRobot {
	/** 
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		CommandList.init();
		SubsystemList.elevator.init();
		SmartDashboard.putNumber("elevate", 0);
		SmartDashboard.putNumber("lift", 0);
		SmartDashboard.putNumber("intake", 0);
		SmartDashboard.putNumber("drive", 0);
	}

	public void disabledPeriodic() {
	}

	public void autonomousInit() {
		CommandList.autonomous.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		CommandList.autonomous.cancel();
		CommandList.run();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
