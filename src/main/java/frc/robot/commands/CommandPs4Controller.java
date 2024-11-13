// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import frc.robot.RobotContainer;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.PS4Controller;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;


/** An example command that uses an example subsystem. */
public class CommandPs4Controller extends Command {
  
  private DriveTrainSubsystem driveTrainSubsystem;
  private DoubleSupplier forwardSpeed;
  private DoubleSupplier turningSpeed;



  //I need to switch the joystick to ps4 control
  public void CommandPS4Controller(DriveTrainSubsystem driveTrainSubsystem) {
     //Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrainSubsystem);
  }
    public CommandPs4Controller(DriveTrainSubsystem subsystem, DoubleSupplier forwardSpeed, DoubleSupplier turningSpeed) {
      this.driveTrainSubsystem = subsystem;
      this.forwardSpeed = forwardSpeed;
      this.turningSpeed = turningSpeed;
      addRequirements(subsystem); // Ensure this command requires the subsystem
    }
  
 
  public void execute(PS4Controller ps4Controller) {
    // Get joystick inputs from DoubleSupplier
    double forward = forwardSpeed.getAsDouble();
    double turn = turningSpeed.getAsDouble();
  

    // Pass the joystick inputs to the arcadeDrive method
    driveTrainSubsystem.arcadeDrive(forward, turn);
    driveTrainSubsystem.arcadeDrive(ps4Controller.getLeftY(),ps4Controller.getRightX() );
  }
  /* 
  public void RobotContainer(){
    
    configurebindings();
  }

  public void configurebindings(){
    driveTrainSubsystem.setDefaultCommand(new CommandPs4Contoller(driveTrainSubsystem,
      ()-> PS4Controller.getRightX(),()-> ps4Controller.getLeftY()  ));

  }
 */
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("STARTING DA ROOBOT!!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  //@Override
  /* 
  public void execute() {
    double forwardSpeed = RobotContainer.getLeftY();
    double turningSpeed = RobotContainer.getRightX();

    RobotContainer.driveTrainSubsystem.arcadeDrive(forwardSpeed,turningSpeed);
  }
*/
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  
  }

