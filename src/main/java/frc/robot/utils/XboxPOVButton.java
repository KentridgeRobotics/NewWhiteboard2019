/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;


/**
 * Deals with D-Pad buttons on Xbox controller
 */
public class XboxPOVButton {
    private final edu.wpi.first.wpilibj.XboxController controller;
	private final POVDirection povDirection;

	public XboxPOVButton(edu.wpi.first.wpilibj.XboxController controller, POVDirection povDirection) {
		this.controller = controller;
		this.povDirection = povDirection;
	}

	/**
	 * Gets the value of the joystick button.
	 *
	 * @return The value of the joystick button
	 */
	public boolean get() {
		switch (povDirection) {
		case UP:
			return (controller.getPOV(0) == 315 || controller.getPOV(0) == 0 || controller.getPOV(0) == 45) ? true
					: false;
		case RIGHT:
			return (controller.getPOV(0) == 45 || controller.getPOV(0) == 90 || controller.getPOV(0) == 135) ? true
					: false;
		case DOWN:
			return (controller.getPOV(0) == 135 || controller.getPOV(0) == 180 || controller.getPOV(0) == 225) ? true
					: false;
		case LEFT:
			return (controller.getPOV(0) == 225 || controller.getPOV(0) == 270 || controller.getPOV(0) == 315) ? true
					: false;
		default:
			return false;
		}
	}

	public enum POVDirection {
		UP, RIGHT, DOWN, LEFT;
	}
}
