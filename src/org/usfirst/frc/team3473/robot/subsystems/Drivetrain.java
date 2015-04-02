package org.usfirst.frc.team3473.robot.subsystems;

import org.usfirst.frc.team3473.robot.IO;
import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;

public class Drivetrain {
	boolean LOWGEAR = true;

	public void run() {
		commonsenseDriveWithShift();
		shift();
	}

	private void commonsenseDriveWithShift() {
		double turnAngle = -IO.JOYSTICK_wheel.getX();
		double speed = -IO.JOYSTICK_throttle.getY();
		speed = taperSpeed(speed);
		
		if (LOWGEAR) {
			speed = .75 * speed;
			if (IO.BUTTON_override.get() && Math.abs(turnAngle) > .15) {
				turnAngle *= .75;
				setLeft((turnAngle > 0) ? -turnAngle : -turnAngle);
				setRight((turnAngle > 0) ? turnAngle : turnAngle);
			} else if (Math.abs(turnAngle) > .15 && Math.abs(speed) > .1) {
				setLeft((turnAngle > 0) ? (speed / (turnAngle + 3)) : speed);
				setRight((turnAngle > 0) ? speed : speed / (-turnAngle + 3));

			} else if (Math.abs(speed) > .1) {
				setAll(speed);
			} else {
				stopDrive();
			}
		} else {
			speed = .6 * speed;
			if (IO.BUTTON_override.get() && Math.abs(turnAngle) > .15) {
				turnAngle *= .6;
				setLeft((turnAngle > 0) ? -turnAngle : -turnAngle);
				setRight((turnAngle > 0) ? turnAngle : turnAngle);
			} else if (Math.abs(turnAngle) > .15 && Math.abs(speed) > .1) {
				RobotMap.TALON_left1.set((turnAngle > 0) ? (speed / (turnAngle + 3)) : speed);
				RobotMap.TALON_right1.set((turnAngle > 0) ? speed : speed	/ (-turnAngle + 3));
			} else if (Math.abs(speed) > .1) {
				RobotMap.TALON_left1.set(speed);
				RobotMap.TALON_right1.set(-speed);
			} else {
				stopDrive();
			}
		}
	}

  adjust speed for smoother driving
	private double taperSpeed(double speed) {
		if (Math.abs(speed) >= .99) {
			return speed;
		} else {
			boolean negative = false;
			if (speed < 0) {
				negative = true;
			}
			double adjSpeed = Math.pow(speed, 2);
			return (negative) ? -adjSpeed : adjSpeed;
		}
	}
	
	//shift gears
	private void shift() {
		if (IO.BUTTON_shift.get()) {
			if (RobotMap.SOLENOID_shifter.get().equals(Value.kReverse)) {
				RobotMap.SOLENOID_shifter.set(Value.kForward);
				LOWGEAR = true;
			} else {
				RobotMap.SOLENOID_shifter.set(Value.kReverse);
				LOWGEAR = false;
			}
		}
	}

	public void setAll(double speed) {
		setLeft(speed);
		setRight(speed);
	}

	public void setRight(double speed) {
		RobotMap.TALON_right1.set(-speed);
		RobotMap.TALON_right2.set(-speed);
	}

	public void setLeft(double speed) {
		RobotMap.TALON_left1.set(speed);
		RobotMap.TALON_left2.set(speed);
	}

	public void stopDrive() {
		setLeft(0);
		setRight(0);
	}

	public void turnRight(double speed) {
		setLeft(speed);
		setRight(-speed);
	}

  //wheel+throttle
	private void commonsenseDrive() {
		double turnAngle = -IO.JOYSTICK_wheel.getX();
		double speed = -IO.JOYSTICK_throttle.getY() * .75;

		if (IO.BUTTON_override.get() && Math.abs(turnAngle) > .1) {
			turnAngle *= .75;
			setLeft((turnAngle > 0) ? -turnAngle : -turnAngle);
			setRight((turnAngle > 0) ? turnAngle : turnAngle);
		} else if (Math.abs(turnAngle) > .1 && Math.abs(speed) > .1) {
			setLeft((turnAngle > 0) ? (speed / (turnAngle + 3)) : speed);
			setRight((turnAngle > 0) ? speed : speed / (-turnAngle + 3));

		} else if (Math.abs(speed) > .1) {
			setAll(speed);
			// this.balancev5();
		} else {
			stopDrive();
		}
	}

  //joysticks on gamepad
	private void buttonDrive() {
		double leftSpeed = -IO.JOYSTICK_gamepad.getY() * .75;
		double rightSpeed = -IO.JOYSTICK_gamepad.getRawAxis(5) * .75;
		setLeft((Math.abs(leftSpeed) > .075) ? leftSpeed : 0);
		setRight((Math.abs(rightSpeed) > .075) ? rightSpeed : 0);
	}

	private void tankDrive() {
		double leftSpeed = -IO.JOYSTICK_left.getY() * .75;
		double rightSpeed = -IO.JOYSTICK_right.getY() * .75;
		setLeft((Math.abs(leftSpeed) > .075) ? leftSpeed : 0);
		setRight((Math.abs(rightSpeed) > .075) ? rightSpeed : 0);
	}

  //adjust robot to drive straight w/ gyro input
	public void autonBalance(int angle) {
		double gyroVal = RobotMap.SENSOR_gyro.getAngle();
		if (Math.abs(gyroVal) > (angle + 1)) {
			if (gyroVal < 0) {
				setLeft(RobotMap.TALON_left1.get() * .99);
			} else {
				setRight(RobotMap.TALON_right1.get() * .99);
			}
			Timer.delay(.005);
		}
	}

}
