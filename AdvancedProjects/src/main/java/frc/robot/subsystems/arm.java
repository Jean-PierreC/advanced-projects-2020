/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;

import frc.robot.RobotMap;
import frc.robot.OI;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * Add your docs here.
 */
public class arm extends Subsystem {
  private PWMTalonSRX arm= new PWMTalonSRX(RobotMap.liftPort);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public static arm Arm;
  public arm() {
  }
  public static arm getInstance() {
    if (Arm == null) {
      Arm = new arm();
    }
    return Arm;
  }

  
  public void UarmDrive(double armPow){
    if (armPow < 0.05 && armPow > -0.05) {
      armPow = 0;
    }
    arm.set(armPow);
  }

  public void DarmDrive(double armPow){
    if (armPow < 0.05 && armPow > -0.05) {
      armPow = 0;
    }
    arm.set(-armPow);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  @Override
  public void periodic(){
    UarmDrive(OI.returnController().getRawAxis(RobotMap.Lthrust) * 0.3);
    DarmDrive(OI.returnController().getRawAxis(RobotMap.Rthrust) * 0.3);

  }
}
