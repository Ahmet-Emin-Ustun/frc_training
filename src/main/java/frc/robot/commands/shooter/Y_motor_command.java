// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Shooterbutcooler;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Y_motor_command extends PIDCommand {
  static double target;
  static Shooterbutcooler shotY = new Shooterbutcooler();
  /** Creates a new Y_motor_command. */
  public Y_motor_command() {
    super(
        // The controller that the command will use
        new PIDController(0, 0, 0),
        // This should return the measurement
        shotY :: getMeasurement,
        // This should return the setpoint (can also be a constant)
        target,
        // This uses the output
        output -> {
          // Use the output here
          shotY.useOutput(output, target);
        }
        );
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
      addRequirements(shotY);
      getController().enableContinuousInput(-180, 180);
      getController().setTolerance(6);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return shotY.atsetpoint();
  }
}
