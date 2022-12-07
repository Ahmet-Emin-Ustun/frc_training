// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class Intake_close extends CommandBase {
private final Intake Insub;
private boolean oopen = true;
  /** Creates a new Intake_close. */
  public Intake_close(Intake Intasub,boolean Isitopen) {
     Insub = Intasub;
     oopen = Isitopen;
    addRequirements(Intasub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     Insub.CloseIntake();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  
  public void end(boolean interrupted) {
    oopen = false;
 }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
