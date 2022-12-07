// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
private final Drivetrain Drivy;
double Xval = 0;
double Zval = 0;
  /** Creates a new Drive. */
  public Drive(Drivetrain drisub,double Xvalue,double Zvalue) {
    Drivy = drisub;
    Xval = Xvalue;
    Zval = Zvalue;
    addRequirements(drisub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     Drivy.driving(Xval, Zval);
    
  }

  
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
