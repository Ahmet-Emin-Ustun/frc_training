// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public Intake() {}

  public Spark Intakemot = new Spark(5);
  public Compressor compy = new Compressor(null);
  public Solenoid solen = new Solenoid(null, 1);
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void OpenIntake() {
    
      solen.set(true);
  }
  
 public void getthatball(double speed){
  Intakemot.set(speed);
 }

  public void CloseIntake() {
    Intakemot.set(0);
    solen.set(false);

}

}
