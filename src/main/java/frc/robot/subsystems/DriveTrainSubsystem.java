// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;
//import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//import java.sql.Driver;

import com.revrobotics.CANSparkMax;
//import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class DriveTrainSubsystem extends SubsystemBase {
  /* This Code is for SparkMax Motor Controls and Neo Motors, I'm planning to use this as the main template for the Serve Modules (YAY). */
        //Just add right CANID in Constants.java -Josh 
  CANSparkMax LeftFrontMotor = new CANSparkMax(Constants.DriveTrainConstant.LeftFrontCANID,MotorType.kBrushed);
    CANSparkMax LeftBackMotor = new CANSparkMax(Constants.DriveTrainConstant.LeftBackCANID,MotorType.kBrushed);
  CANSparkMax RightFrontMotor = new CANSparkMax(Constants.DriveTrainConstant.RightFrontCANID,MotorType.kBrushed);
     CANSparkMax RightBackMotor = new CANSparkMax(Constants.DriveTrainConstant.RightBackCANID,MotorType.kBrushed);
   

 //RelativeEncoder leftEncoder = LeftFrontMotor.getEncoder();
 //RelativeEncoder righEncoder = RightFrontMotor.getEncoder();

  

  private DifferentialDrive drive = new DifferentialDrive(RightFrontMotor, LeftFrontMotor); 
  

  public DriveTrainSubsystem() {
    //just for safety imma make the MotorContols be in Factory Setting so it doesn't get messed up
    LeftFrontMotor.restoreFactoryDefaults();
    LeftBackMotor.restoreFactoryDefaults();
    RightFrontMotor.restoreFactoryDefaults();
    RightBackMotor.restoreFactoryDefaults();
    
    //righEncoder.setPosition(0);
    //leftEncoder.setPosition(0);

    LeftBackMotor.follow(LeftFrontMotor);  // leftBackMotor follows leftFrontMotor
    RightBackMotor.follow(RightFrontMotor); // rightBackMotor follows rightFrontMotor

    
    drive.setSafetyEnabled(false);
    drive.setExpiration(0.1);
  }
    
    public void arcadeDrive(double forwardSpeed,double turningSpeed){
     drive.arcadeDrive(forwardSpeed, turningSpeed); 
    
    }
    
   
    /*
    //Use this if the motors are inverted ot wtv (remember to take off the "/*") - Josh 
    LeftFrontMotor.setInverted(true,false);
    LeftBackMotor.setInverted(true,false);
    RightFrontMotor.setInverted(true,false); 
    RightBackMotor.setInverted(true,false);  
  
    /**
   * Example command factory method.
   *
   * @return a command
   */
    public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  }

 

