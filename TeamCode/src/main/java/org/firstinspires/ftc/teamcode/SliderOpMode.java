package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevColorSensorV3;

public class SliderOpMode extends CommandOpMode{
    private Motor SlideMotor;
    private SlideSubsystem slideSubsystem;


    @Override
    public void initialize() {
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Driver Station)
        SlideMotor = new Motor(hardwareMap, "leftSlideMotor");

        // Set zero power behavior
        SlideMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);


        // Reset encoders
        SlideMotor.resetEncoder();

        slideSubsystem = new SlideSubsystem(SlideMotor, SlideMotor);

        if(gamepad2.circle){
            slideSubsystem.slideLevel1();
        } else if (gamepad2.cross) {
            slideSubsystem.slideLevel2();
        } else if(gamepad2.square){
            slideSubsystem.slideLevel3();
        } else if(gamepad2.triangle){
            slideSubsystem.slideLevel4();
        }else if(gamepad2.right_bumper){
            slideSubsystem.slideMaxExtended();
        }else if(gamepad2.left_bumper){
            slideSubsystem.slideHome();
        }
    }

}
