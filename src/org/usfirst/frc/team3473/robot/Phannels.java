package org.usfirst.frc.team3473.robot;

/**
 * 
 * @author Forest 
 * Ports + Channels = Phannels
 */
public interface Phannels {
	public static int
		/**
		 * Talons
		 */
		 PORT_rightDrivebase1 = 2,
		 PORT_rightDrivebase2 = 7,
		 PORT_leftDrivebase1 = 3,
		 PORT_leftDrivebase2 = 6,
		 PORT_elevator = 5,
		 PORT_intakeR =62, //not used
		 PORT_intakeL=62,  //not used
		 
		/**
		 * Digital IO
		 */
		 PORT_encoder1 = 0,
		 PORT_encoder2 = 1,
		 PORT_limitElevatorUp =2,
		 PORT_limitElevatorDown=3,
		 
		/**
		 * Analog IO
		 */
		 PORT_gyro = 0,
		 PORT_pot = 1,
	
		/**
		 * Solenoid Channels
		 */
		 CHANNEL_shifter1 = 0,
		 CHANNEL_shifter2 = 1,
		 CHANNEL_lift1 = 2,
		 CHANNEL_lift2 = 3,
		 CHANNEL_intake = 4;
}
