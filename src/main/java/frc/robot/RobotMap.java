/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.drive.ChangeDriveMode;
import frc.robot.commands.diskLoader.loadDiskCommand;
import frc.robot.utils.XboxController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Controller IDs
  public final static int primaryController = 0;
  public final static int secondaryController = 1;
  //CAN IDs
  public final static int leftDrive = 1;
  public final static int rightDrive = 2;
  public final static int flinger = 3;
  public final static int tilter = 4;
  public final static int loader = 5;

  public static void setUpDefaultMappings() {
    XboxController primary = OI.getPrimaryController();
    primary.buttonMenu.whenPressed(new ChangeDriveMode());

    XboxController secondary = OI.getSecondaryController();
    secondary.buttonX.whileHeld(new loadDiskCommand());
  }

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
