// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class shotball extends CommandBase {
private final Shooter shoty;
  /** Creates a new shotball. */
  public shotball(Shooter m_shooter) {
    shoty = m_shooter;
    addRequirements(shoty);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shoty.shottheball();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
