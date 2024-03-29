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
public class DiskLoadSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static DiskLoadSubsystem instance;

  private WPI_TalonSRX loader;

  public static DiskLoadSubsystem getInstance() {
    if (instance == null) {
      instance = new DiskLoadSubsystem();
    }
    return instance;
  }

  public DiskLoadSubsystem() {
    
    loader = new WPI_TalonSRX(RobotMap.loader);
  }
  public void setLoaderSpeed (double speed){
    loader.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
