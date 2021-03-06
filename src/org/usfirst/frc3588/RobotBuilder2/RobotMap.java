// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3588.RobotBuilder2;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Gyro pIDDriveGyro1;
    public static SpeedController pIDDriveleftFrontWheel;
    public static SpeedController pIDDriverightFrontWheel;
    public static SpeedController pIDDriveleftRearWheel;
    public static SpeedController pIDDriverightRearWheel;
    public static RobotDrive pIDDriveDriveTrain;
    public static AnalogChannel pIDDriveAnalogInput1;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        pIDDriveGyro1 = new Gyro(1, 1);
	LiveWindow.addSensor("PID Drive", "Gyro 1", pIDDriveGyro1);
        pIDDriveGyro1.setSensitivity(0.007);
        pIDDriveleftFrontWheel = new Jaguar(1, 1);
	LiveWindow.addActuator("PID Drive", "leftFrontWheel", (Jaguar) pIDDriveleftFrontWheel);
        
        pIDDriverightFrontWheel = new Jaguar(1, 2);
	LiveWindow.addActuator("PID Drive", "rightFrontWheel", (Jaguar) pIDDriverightFrontWheel);
        
        pIDDriveleftRearWheel = new Jaguar(1, 3);
	LiveWindow.addActuator("PID Drive", "leftRearWheel", (Jaguar) pIDDriveleftRearWheel);
        
        pIDDriverightRearWheel = new Jaguar(1, 4);
	LiveWindow.addActuator("PID Drive", "rightRearWheel", (Jaguar) pIDDriverightRearWheel);
        
        pIDDriveDriveTrain = new RobotDrive(pIDDriveleftFrontWheel, pIDDriveleftRearWheel,
              pIDDriverightFrontWheel, pIDDriverightRearWheel);
	
        pIDDriveDriveTrain.setSafetyEnabled(false);
        pIDDriveDriveTrain.setExpiration(0.1);
        pIDDriveDriveTrain.setSensitivity(0.5);
        pIDDriveDriveTrain.setMaxOutput(1.0);
        pIDDriveAnalogInput1 = new AnalogChannel(1, 2);
	LiveWindow.addSensor("PID Drive", "Analog Input 1", pIDDriveAnalogInput1);
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
