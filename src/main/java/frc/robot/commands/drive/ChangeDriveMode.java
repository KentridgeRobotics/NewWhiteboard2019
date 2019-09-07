/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ChangeDriveMode extends Command {
  public ChangeDriveMode() {
    
  }

  @Override
  protected void initialize() {
    SmartDashboard.putString("Change Drive Mode", "Initialized");
  }

  @Override
  protected void execute() {
    if(ArcadeDriveCommand.getInstance().isRunning()) {
      ArcadeDriveCommand.getInstance().cancel();
      TankDriveCommand.getInstance().start();
    }
    else {
      TankDriveCommand.getInstance().cancel();
      ArcadeDriveCommand.getInstance().start();
    }
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
    SmartDashboard.putString("Change Drive Mode", "Switched Modes");
  }

  
  @Override
  protected void interrupted() {
    end();
  }
}
