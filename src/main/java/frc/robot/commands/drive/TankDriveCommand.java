/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.subsystems.DriveSubsystem;

public class TankDriveCommand extends Command {

  public static TankDriveCommand instance;

  public static TankDriveCommand getInstance() {
    if(instance == null)
      instance = new TankDriveCommand();
    return instance;
  }
  public TankDriveCommand() {
    requires(DriveSubsystem.getInstance());
  }

  @Override
  protected void initialize() {
    SmartDashboard.putString("Drive Mode", "Tank");
  }

  @Override
  protected void execute() {
    DriveSubsystem.getInstance().tankDrive(OI.getRobotThrottle(), OI.getRightStickY());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    DriveSubsystem.getInstance().setMotorSpeeds(0.0, 0.0);
    SmartDashboard.putString("Drive Mode", "Tank Drive Ending");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
