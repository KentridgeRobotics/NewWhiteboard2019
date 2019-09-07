/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;


public class DriveSubsystem extends Subsystem {

  private static DriveSubsystem instance;

  private WPI_TalonSRX leftDrive;
  private WPI_TalonSRX rightDrive;

  private final DifferentialDrive differentialDrive;

  public static DriveSubsystem getInstance() {
    if (instance == null)
      instance = new DriveSubsystem();
    return instance;
  }

  public DriveSubsystem() {
    leftDrive = new WPI_TalonSRX(RobotMap.leftDrive);
    rightDrive = new WPI_TalonSRX(RobotMap.rightDrive);
    leftDrive.configOpenloopRamp(0.4);
    rightDrive.configOpenloopRamp(0.4);
    
    differentialDrive = new DifferentialDrive(leftDrive, rightDrive);
  }

  public void setMotorSpeeds(double left, double right) {
    leftDrive.set(ControlMode.PercentOutput, left);
    rightDrive.set(ControlMode.PercentOutput, right);
  }

  public void arcadeDrive(double speed, double turnRate) {
    differentialDrive.arcadeDrive(-speed, turnRate);
  }

  public void tankDrive(double left, double right) {
    differentialDrive.tankDrive(left, right);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
