package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class BasicOpMode_Linear extends LinearOpMode {

    private HardwareConfiguration hardwareConfig;
    private ButtonMapping buttonMapping;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize hardware and button mapping
        hardwareConfig = new HardwareConfiguration(hardwareMap);
        buttonMapping = new ButtonMapping(hardwareConfig);

        // Set initial positions
        hardwareConfig.initializePositions();

        // Wait for the start command
        waitForStart();

        // Main loop
        while (opModeIsActive()) {
            // Handle gamepad inputs
            buttonMapping.handleGamepadInputs(gamepad1, gamepad2);

            // Update motor powers based on gamepad inputs
            driveMotors(gamepad1);

            // Update telemetry
            telemetry.addData("Servo Position", hardwareConfig.getMotorPosition());
            telemetry.update();
        }
    }

    private void driveMotors(Gamepad gamepad1) {

        double ltp = gamepad1.left_trigger;



        float xr = gamepad1.right_stick_x;
        float ym = gamepad1.left_stick_y, xm = gamepad1.left_stick_x;


        // Set motor powers
        hardwareConfig.frontLeftMotor.setPower(-xm+ym-xr);
        hardwareConfig.backLeftMotor.setPower(xm+ym-xr);
        hardwareConfig.frontRightMotor.setPower(xm+ym+xr);
        hardwareConfig.backRightMotor.setPower(-xm+ym+xr);

        // Set slider and intake motor powers
        hardwareConfig.sliderMotor.setPower(ltp * ltp * ltp); // Adjust slider power based on trigger
        hardwareConfig.intakeMotor.setPower(gamepad1.right_trigger * 0.7); // Adjust intake power
    }
}
