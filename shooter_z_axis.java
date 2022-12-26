// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.shooting;


public class shooter_z_axis extends SubsystemBase {
  private final shooting m_shot = new shooting();
  private final Spark Shot_z_Motor = new Spark(0);
  private final Encoder Z_Enco = new Encoder(0, 0);
  private final PIDController m_controller = new PIDController(m_shot.kP, m_shot.kI, m_shot.kD);
  /** Creates a new shooter_z_axis. */
  public shooter_z_axis() {
    m_controller.setTolerance(m_shot.mistake);
    m_controller.enableContinuousInput(-180, 180);
    Z_Enco.setDistancePerPulse(m_shot.tickstodegree);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void turn(double angle){
  
      double output = m_controller.calculate(Z_Enco.getDistance(), angle);
      Shot_z_Motor.set(output);
  }

  public void reset(){
    Z_Enco.reset();
  }
  
  public boolean IsFinished(){
    return m_controller.atSetpoint();
  }
}
