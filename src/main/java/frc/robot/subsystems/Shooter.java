// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  public Spark shot = new Spark(6);
  public Spark Zmotor = new Spark(7);
  public Spark Ymotor = new Spark(8);

  public Encoder Z_enco = new Encoder(null, null);
  public Encoder Y_enco = new Encoder(null, null);

  /** Creates a new Shooter. */
  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void lock(){
    
  }

  public void shottheball(){
      shot.set(0.5);
  }

  
}
