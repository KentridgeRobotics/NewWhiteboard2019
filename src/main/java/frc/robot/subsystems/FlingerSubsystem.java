/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class FlingerSubsystem extends Subsystem {

  private static FlingerSubsystem instance;

  private WPI_TalonSRX flinger;

  public static FlingerSubsystem getInstance() {
    if (instance == null) {
      instance = new FlingerSubsystem();
    }
    return instance;
  }

  public FlingerSubsystem () {
    flinger = new WPI_TalonSRX(RobotMap.flinger);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
