// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class turn_Y extends CommandBase {
  Shooter m_shooter = new Shooter();
  double Tangle ;
  /** Creates a new turn_Y. */
  public turn_Y(Shooter m_shot, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    Tangle = angle;
    m_shot = m_shooter;
    addRequirements(m_shot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.turn(Tangle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_shooter.IsFinished();
  }
}
