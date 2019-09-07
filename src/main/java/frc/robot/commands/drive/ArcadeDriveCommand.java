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

public class ArcadeDriveCommand extends Command {

  public static ArcadeDriveCommand instance;

  public static ArcadeDriveCommand getInstance() {
    if (instance == null)
      instance = new ArcadeDriveCommand();
    return instance;

  }
  public ArcadeDriveCommand() {
    requires(DriveSubsystem.getInstance());
  }

  @Override
  protected void initialize() {
    SmartDashboard.putString("Drive Mode", "Arcade");
  }

  @Override
  protected void execute() {
    DriveSubsystem.getInstance().arcadeDrive(OI.getRobotThrottle(), OI.getRobotTurn());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    DriveSubsystem.getInstance().setMotorSpeeds(0.0, 0.0);
    SmartDashboard.putString("Drive Mode", "Arcade Drive Ending");
  }

  @Override
  protected void interrupted() {
    end();
  }
}
