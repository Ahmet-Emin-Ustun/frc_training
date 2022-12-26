// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class Intake_open extends CommandBase {
private final Intake Insub;

  /** Creates a new Intake_open. */
  public Intake_open(Intake Intasub) {
    Insub = Intasub;

    addRequirements(Intasub);
  }

  // Called when the command is initially scheduled.
 
  public void initialize() {
    Insub.OpenIntake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  
  public void execute() {
    Insub.getthatball(0.5);
  }

  // Called once the command ends or is interrupted.
  
  public void end(boolean interrupted) {
     if(interrupted == true){
        Insub.CloseIntake();
     }
    
  }

  // Returns true when the command should end.
  
  public boolean isFinished() {
    return false;
  }
}
