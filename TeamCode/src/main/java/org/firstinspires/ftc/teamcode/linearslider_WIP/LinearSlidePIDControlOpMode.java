package org.firstinspires.ftc.teamcode.linearslider_WIP;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class LinearSlidePIDControlOpMode extends LinearOpMode {

    // Declare hardware variables (e.g., motors)
    private DcMotor slideMotor;

    @Override
    public void runOpMode() {
        // Initialize hardware
        slideMotor = hardwareMap.get(DcMotor.class, "slideMotor");
        // Set motor mode to use encoder feedback
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // setpoint (desired height)
        PIDController pidController = new PIDController(0.1, 0.01, 0.05, 1000);


        waitForStart();

        while (opModeIsActive()) {
            double currentHeight = slideMotor.getCurrentPosition();
            double deltaTime = 0.05;  // 50ms loop interval
            double motorPower = pidController.compute(currentHeight, deltaTime);
            motorPower = Math.max(Math.min(motorPower, 1), -1);

            slideMotor.setPower(motorPower);

            telemetry.addData("Current Height", currentHeight);
            //telemetry.addData("Motor Power", motorPower);
            telemetry.update();

            sleep(50);  // Control loop interval
        }
    }
}
