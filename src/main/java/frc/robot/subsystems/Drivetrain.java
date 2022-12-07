// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
 public Spark leftFrontmotor = new Spark(0);
  public Spark leftRearmotor =  new Spark(1);
  public Spark rightFrontmotor = new Spark(2);
  public Spark rightRearmotor =  new Spark(3);
 
  
   public MotorControllerGroup leftmotors = new MotorControllerGroup(leftFrontmotor, leftRearmotor);
   public MotorControllerGroup rightmotors = new MotorControllerGroup(rightFrontmotor, rightRearmotor);
   AnalogGyro m_Gyro = new AnalogGyro(0);

   DifferentialDrive Drive = new DifferentialDrive(leftmotors,rightmotors); 
   
   double kP = 0.5;
   
  public Drivetrain() {}


   public void driving(double Xspeed ,double Zspeed){
    if(Math.abs(Xspeed) <= 0.10){
      Xspeed = 0;
    }
    if(Math.abs(Zspeed) <= 0.10){
      Zspeed = 0;
    }
    
    if(Xspeed == 0 && Zspeed != 0){
      DifferentialDrive.arcadeDriveIK(-Xspeed, Zspeed, false); 
    }
    
    else if(Xspeed == 0 && Zspeed == 0){
       double error = -m_Gyro.getRate();
       double turning = kP*error;
       DifferentialDrive.arcadeDriveIK(-Xspeed, turning, false);
    }

   }
    
  @Override
  public void periodic() {
    


  }
}
