// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class Shooterbutcooler extends PIDSubsystem {
  //defines motors
   private final Spark Y_motor = new Spark(8);
   private final Spark s_motor = new Spark(10);
  
   private final Encoder Y_enco = new Encoder(3, 5,false);
   double entodeg = 360 / 512 * 26 / 42 * 18 / 60 * 18 / 84;
   double Ychangedeg = Y_enco.get() * entodeg;
  /** Creates a new Shooterbutcooler. */
  public Shooterbutcooler() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0));
       

  }

  //@Override
  public void useOutput(double output, double setpoint) {
    Y_motor.set(output - m_controller.calculate(Ychangedeg, setpoint));
  }
   
  public void shot(){
    s_motor.set(0.6);
  }

  public boolean atsetpoint(){
    return m_controller.atSetpoint();
  }

  //@Override
  public double getMeasurement() {
    // Return the process variable measurement here
    
    return Ychangedeg;
  }
}
