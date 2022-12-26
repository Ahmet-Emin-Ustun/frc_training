// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.Drive;
import frc.robot.commands.Intake.Intake_close;
import frc.robot.commands.Intake.Intake_open;
import frc.robot.commands.shooter.shotball;
import frc.robot.commands.shooter.turn_Y;
import frc.robot.commands.shooter.turn_Z;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.shooter_z_axis;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Intake m_Intake = new Intake();
 private final Shooter m_shooter = new Shooter();
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final shooter_z_axis mZ_axis = new shooter_z_axis();

   
  XboxController cont = new XboxController(3);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_drivetrain.setDefaultCommand(new Drive(m_drivetrain, cont.getLeftY(), cont.getLeftX()));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
 
    new JoystickButton(cont, Button.kA.value).whileActiveOnce(new Intake_open(m_Intake), true);
    new JoystickButton(cont, Button.kA.value).whileActiveOnce(new Intake_close(m_Intake), true);
    

    new JoystickButton(cont, Button.kB.value).whenActive(new shotball(m_shooter));   

    new JoystickButton(cont, Button.kX.value).whenPressed(new turn_Z(mZ_axis, 90));
    new JoystickButton(cont, Button.kY.value).whenPressed(new turn_Y(m_shooter, 20));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
