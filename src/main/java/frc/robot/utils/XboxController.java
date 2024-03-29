/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import java.util.HashMap;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.utils.XboxPOVButton.POVDirection;

/**
 * Custom Xbox Controller class from 2019Robot
 */
public class XboxController {
    private static final HashMap<Integer, XboxController> instances = new HashMap<Integer, XboxController>();

	edu.wpi.first.wpilibj.XboxController controller;

	public JoystickButton buttonA;
	public JoystickButton buttonB;
	public JoystickButton buttonX;
	public JoystickButton buttonY;
	public JoystickButton buttonBumperLeft;
	public JoystickButton buttonBumperRight;
	public JoystickButton buttonView;
	public JoystickButton buttonMenu;
	public JoystickButton buttonStickLeft;
	public JoystickButton buttonStickRight;
	public XboxPOVButton buttonPovUp;
	public XboxPOVButton buttonPovRight;
	public XboxPOVButton buttonPovDown;
	public XboxPOVButton buttonPovLeft;

	private static final double deadzone = 0.13;

	public XboxController() {
		this(0);
	}

	public XboxController(int id) {
		controller = new edu.wpi.first.wpilibj.XboxController(id);
		setupButtons();
		instances.put(id, this);
	}

	public static XboxController getInstance(int id) {
		return instances.get(id);
	}

	private void setupButtons() {
		buttonA = new JoystickButton(controller, XboxControllerButton.A.getId());
		buttonB = new JoystickButton(controller, XboxControllerButton.B.getId());
		buttonX = new JoystickButton(controller, XboxControllerButton.X.getId());
		buttonY = new JoystickButton(controller, XboxControllerButton.Y.getId());
		buttonBumperLeft = new JoystickButton(controller, XboxControllerButton.BUMPER_LEFT.getId());
		buttonBumperRight = new JoystickButton(controller, XboxControllerButton.BUMPER_RIGHT.getId());
		buttonView = new JoystickButton(controller, XboxControllerButton.VIEW.getId());
		buttonMenu = new JoystickButton(controller, XboxControllerButton.MENU.getId());
		buttonStickLeft = new JoystickButton(controller, XboxControllerButton.STICK_LEFT.getId());
		buttonStickRight = new JoystickButton(controller, XboxControllerButton.STICK_RIGHT.getId());
        buttonPovUp = new XboxPOVButton(controller, POVDirection.UP);
		buttonPovRight = new XboxPOVButton(controller, POVDirection.RIGHT);
		buttonPovDown = new XboxPOVButton(controller, POVDirection.DOWN);
		buttonPovLeft = new XboxPOVButton(controller, POVDirection.LEFT);
	}

	public double getLeftStickX() {
		double n = controller.getX(Hand.kLeft);
		if (Math.abs(n) <= deadzone)
			return 0.0;
		else {
			double c = (Math.abs(n) - deadzone) / (1.0 - deadzone);
			return (n > 0) ? c : -c;
		}
	}

	public double getLeftStickY() {
		double n = controller.getY(Hand.kLeft);
		if (Math.abs(n) <= deadzone)
			return 0.0;
		else {
			double c = (Math.abs(n) - deadzone) / (1.0 - deadzone);
			return (n > 0) ? c : -c;
		}
	}

	public double getRightStickX() {
		double n = controller.getX(Hand.kRight);
		if (Math.abs(n) <= deadzone)
			return 0.0;
		else {
			double c = (Math.abs(n) - deadzone) / (1.0 - deadzone);
			return (n > 0) ? c : -c;
		}
	}

	public double getRightStickY() {
		double n = controller.getY(Hand.kRight);
		if (Math.abs(n) <= deadzone)
			return 0.0;
		else {
			double c = (Math.abs(n) - deadzone) / (1.0 - deadzone);
			return (n > 0) ? c : -c;
		}
	}

	public double getLeftTrigger() {
		return controller.getTriggerAxis(Hand.kLeft);
	}

	public double getRightTrigger() {
		return controller.getTriggerAxis(Hand.kRight);
	}

	public enum XboxControllerButton {
		A(1), B(2), X(3), Y(4), BUMPER_LEFT(5), BUMPER_RIGHT(6), VIEW(7), MENU(8), STICK_LEFT(9), STICK_RIGHT(10);

		private final int id;

		XboxControllerButton(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

}
