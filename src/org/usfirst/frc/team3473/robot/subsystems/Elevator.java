package org.usfirst.frc.team3473.robot.subsystems;

import org.usfirst.frc.team3473.robot.IO;
import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Forest
 */
public class Elevator {
	private int initVal;
	private int lastPos;
	private double autonSpeed = -.7;
	
	public void run() {
		controlAnalog();
		monitor();
	}

  //initialize initVal and lastPos values
	public void init() {
		initVal = lastPos = RobotMap.SENSOR_pot.getValue();
	}

  //put data onto SmartDashboard
	private void monitor() {
		SmartDashboard.putNumber("raw pot", RobotMap.SENSOR_pot.getValue());
		SmartDashboard.putNumber("turns", turns(initVal));
	}

  //returns number of turns through potentiometer input
	private double turns(int pos) {
		int i = RobotMap.SENSOR_pot.getValue();
		double numTurns = ((double) (pos - i)) / 20;
		return (numTurns > 10) ? 10 : numTurns;
	}
  
	private void stop() {
		RobotMap.TALON_elevator.set(0);
	}
	
	//control the elevator with analog input
	private void controlAnalog() {
		double value = IO.JOYSTICK_gamepad.getY();
		if (Math.abs(value) > .05) {
			if (!RobotMap.SENSOR_limitElevatorDown.get()) {
				if (value < 0) {
					RobotMap.TALON_elevator.set(-value); //positive = up
				} else {
					stop();
				}
			} else {

				RobotMap.TALON_elevator.set(-value);
			}
		} else {
			stop();
		}
	}
}
