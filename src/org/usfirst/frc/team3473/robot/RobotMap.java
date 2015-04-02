package org.usfirst.frc.team968.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	/**
	 *  Sensors
	 */
	public static Encoder SENSOR_encoder;
	public static Gyro SENSOR_gyro;
	public static AnalogInput SENSOR_pot;
	public static AnalogInput SENSOR_IR;
	public static DigitalInput SENSOR_limitElevatorUp;
	public static DigitalInput SENSOR_limitElevatorDown;

	/** 
	 *  Talons
	 */
	public static CANTalon TALON_right1;
	public static CANTalon TALON_right2;
	public static CANTalon TALON_left1;
	public static CANTalon TALON_left2;
	public static CANTalon TALON_elevator;
	public static CANTalon TALON_intakeR;
	public static CANTalon TALON_intakeL;
	
	/**
	 *  Solenoids
	 */
	public static DoubleSolenoid SOLENOID_shifter;
	public static DoubleSolenoid SOLENOID_lift;
	public static Solenoid SOLENOID_intake;
	
	/**
	 *  Initialize every sensor, talon, and solenoid
	 */
	public static void init() {
		SENSOR_encoder = new Encoder(Phannels.PORT_encoder1, Phannels.PORT_encoder2, true);
		SENSOR_gyro = new Gyro(Phannels.PORT_gyro);
		SENSOR_pot = new AnalogInput(Phannels.PORT_pot);
		SENSOR_limitElevatorUp = new DigitalInput(Phannels.PORT_limitElevatorUp);
		SENSOR_limitElevatorDown = new DigitalInput(Phannels.PORT_limitElevatorDown);
		 
		TALON_right1 = new CANTalon(Phannels.PORT_rightDrivebase1);
		TALON_right2 = new CANTalon(Phannels.PORT_rightDrivebase2);
		TALON_left1 = new CANTalon(Phannels.PORT_leftDrivebase1);
		TALON_left2 = new CANTalon(Phannels.PORT_leftDrivebase2);
		TALON_elevator = new CANTalon(Phannels.PORT_elevator);
		TALON_intakeR = new CANTalon(Phannels.PORT_intakeL);
		TALON_intakeL = new CANTalon(Phannels.PORT_intakeR);
		
		SOLENOID_shifter = new DoubleSolenoid(Phannels.CHANNEL_shifter1,Phannels.CHANNEL_shifter2);
		SOLENOID_lift = new DoubleSolenoid(Phannels.CHANNEL_lift1,Phannels.CHANNEL_lift2);
		SOLENOID_intake = new Solenoid(Phannels.CHANNEL_intake);
	}
}
