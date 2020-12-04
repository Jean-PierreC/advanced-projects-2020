package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Path1 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Path1() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
    addSequential(new ForwardTimer(2));
    addSequential(new ForwardTimer(-2));
    addSequential(new ForwardTimer(5));
    //addSequential(new TurnRobotTimer(2));
    //addSequential(new DriveForwardTimer(2));
    //addSequential(new TurnRobotTimer(-2));
    //addSequential(new DriveForwardTimer(1.5));;
  }
}