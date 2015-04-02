package org.usfirst.frc.team3473.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * @author Forest 
 */
public class IO { 
	/**
	 *  Controllers for Wheel + Throttle + Gamepad
	 */
	public static final Joystick 
		JOYSTICK_wheel = new Joystick(0),
		JOYSTICK_throttle = new Joystick(1),
		JOYSTICK_gamepad = new Joystick(2);
	
	/**
	 *  Controllers for tankdrive
	 */
	public static final Joystick
		JOYSTICK_right = new Joystick(3),
		JOYSTICK_left = new Joystick(4);

	/**
	 *  Buttons
	 */
	public static final JoystickButton
		 BUTTON_override = new JoystickButton(JOYSTICK_wheel, 6),
		
		 BUTTON_shift = new JoystickButton(JOYSTICK_throttle, 1),
		 
		 BUTTON_intake = new JoystickButton(JOYSTICK_gamepad,1),
		 BUTTON_release = new JoystickButton(JOYSTICK_gamepad,2),
		 BUTTON_elevateUp = new JoystickButton(JOYSTICK_gamepad, 6),
		 BUTTON_elevateDown = new JoystickButton(JOYSTICK_gamepad,5),
		 BUTTON_intakeActuate = new JoystickButton(JOYSTICK_gamepad,3),
		 
		 BUTTON_shiftL = new JoystickButton(JOYSTICK_left, 1),
		
		 BUTTON_shiftR = new JoystickButton(JOYSTICK_right, 1);
}
