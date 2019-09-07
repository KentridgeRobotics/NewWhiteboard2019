/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.utils.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private static XboxController primaryController = null;

  public static XboxController getPrimaryController() {
    if(primaryController == null) {
      primaryController = new XboxController(RobotMap.primaryController);
    }
    return primaryController;
  }

  public static double getRobotTurn() { //arcade drive
		return primaryController.getRightStickX();
	}

  /**
   * Used to get throttle for arcade drive. Can also
   * be used for the power of the robot's left side during tank drive
   */
  public static double getRobotThrottle() { //arcade drive and left throttle
		return primaryController.getLeftStickY();
  }

  public static double getRightStickY() { //tank drive
    return primaryController.getRightStickY();
  }
}
