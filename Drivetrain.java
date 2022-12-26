// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.driving;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

 public frc.robot.Constants.driving m_driving = new driving();

 public Spark leftFrontmotor = new Spark(0);
  public Spark leftRearmotor =  new Spark(1);
  public Spark rightFrontmotor = new Spark(2);
  public Spark rightRearmotor =  new Spark(3);
 
  
   public MotorControllerGroup leftmotors = new MotorControllerGroup(leftFrontmotor, leftRearmotor);
   public MotorControllerGroup rightmotors = new MotorControllerGroup(rightFrontmotor, rightRearmotor);
   AnalogGyro m_Gyro = new AnalogGyro(0);

   DifferentialDrive Drive = new DifferentialDrive(leftmotors,rightmotors); 

   private final Encoder m_left_encoder= new Encoder(1, 3, false);
   private final Encoder m_right_encoder= new Encoder(2,4,true);
   
   private final DifferentialDriveKinematics m_drive_kin = new DifferentialDriveKinematics(m_driving.Tracksize);
   private final PIDController PID_for_Left = new PIDController(m_driving.kP, m_driving.kI, m_driving.kD);
   private final PIDController PID_for_Right = new PIDController(m_driving.kP, m_driving.kI, m_driving.kD);
   
   DifferentialDriveOdometry m_odometry;

   Pose2d m_pose;

   SimpleMotorFeedforward m_forward = new SimpleMotorFeedforward(m_driving.kS, m_driving.kV,m_driving.kA);

  public Drivetrain() {
    m_Gyro.reset();
    rightmotors.setInverted(true);
    
    m_left_encoder.setDistancePerPulse(m_driving.Set_distance_perpulse);
    m_right_encoder.setDistancePerPulse(m_driving.Set_distance_perpulse);
     

  
    m_left_encoder.reset();
    m_right_encoder.reset();
    
    m_odometry = new DifferentialDriveOdometry(m_Gyro.getRotation2d());

  }
  
  public void Motor_speeds(DifferentialDriveWheelSpeeds speed){
    final double left_forward = PID_for_Left.calculate(speed.leftMetersPerSecond);
    final double Right_forward = PID_for_Right.calculate(speed.rightMetersPerSecond);

    final double output_L = PID_for_Left.calculate(m_left_encoder.getRate(), speed.leftMetersPerSecond);
    final double output_R = PID_for_Right.calculate(m_right_encoder.getRate(), speed.rightMetersPerSecond);

    leftmotors.setVoltage(left_forward + output_L);
    rightmotors.setVoltage(Right_forward + output_R);
  }

  public void driving(double Xspeed ,double Zspeed){
    var speedofwheel = m_drive_kin.toWheelSpeeds(new ChassisSpeeds(Zspeed, 0.0, Zspeed));
    Motor_speeds(speedofwheel);
   }
    
  @Override
  public void periodic() {
    var m_GAngle = Rotation2d.fromDegrees(-m_Gyro.getAngle());

   m_pose = m_odometry.update(m_GAngle, m_left_encoder.getDistance(), m_right_encoder.getDistance());
  }

  public double getaveragedistance(){
    return (m_right_encoder.getDistance() + m_right_encoder.getDistance()) / 2; 
  }
  
  public Pose2d getpose(){
    return m_pose;
  }
  
}
