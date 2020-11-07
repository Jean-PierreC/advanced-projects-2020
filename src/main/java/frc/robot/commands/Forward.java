/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;

//This command drives forward using encoder - doesn't work in simulator
public class Forward extends Command {

  //Constants for speed and distance
  private double distance;
  private double motorSpeed;

  public Forward(double distanceInInches, double speed) {
    requires(OI.m_drive);
    distance = distanceInInches;
    motorSpeed = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    OI.m_drive.resetEncoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    OI.m_drive.tankDrive(motorSpeed, motorSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Math.abs(OI.m_drive.returnDistance() - distance) <= 2) {
      return true;
    } else {
      return false;
    }
  }


  @Override
  protected void end() {
    OI.m_drive.tankDrive(0, 0);
  }

  
  @Override
  protected void interrupted() {
  }
}
