package org.usfirst.frc.team3473.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Forest
 */
public class CommandList {
	public static Command autonomous, 
						            drive, 
						            elevate;

	public static void init() {  
		autonomous = new Autonomous();
		drive = new Drive();
		elevate = new Elevate();
	}
	
	public static void run(){
		drive.start();
		elevate.start();
	}

}
