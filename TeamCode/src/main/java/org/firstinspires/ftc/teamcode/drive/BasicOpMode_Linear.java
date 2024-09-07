package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.VisualOpenCv.Camera;
import org.firstinspires.ftc.teamcode.linearslider_WIP.PIDController;

@Config
@TeleOp
public class BasicOpMode_Linear extends LinearOpMode {
    FtcDashboard dashboard;
    private HardwareConfiguration hardwareConfig;
    private ButtonMapping buttonMapping;
    private Camera camera;  // Add camera reference

    double integralSum = 0;
    public static double kp = 0.1;
    public static double ki = 0;
    public static double kd = 0;
 double target = 10;

    ElapsedTime timer = new ElapsedTime();
    private double lastError;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize hardware and button mapping
        hardwareConfig = new HardwareConfiguration(hardwareMap);
        buttonMapping = new ButtonMapping(hardwareConfig);

        // Initialize the camera and start it before waitForStart()
        camera = new Camera(hardwareMap);
        camera.startCamera();  // Start the camera in the init phase

        // Initialize positions for motors, servos, etc.
        hardwareConfig.initializePositions();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the start command
        waitForStart();

        // Main loop
        while (opModeIsActive()) {
            // Handle gamepad inputs
            buttonMapping.handleGamepadInputs(gamepad1, gamepad2);
            hardwareConfig.intakeMotor.setPower(gamepad1.right_trigger * 0.8);  // Intake power
            hardwareConfig.plateServo.setPower(gamepad1.right_trigger * 0.7);

            if(gamepad2.dpad_down)target=0;
            if(gamepad2.dpad_up)target=3000;
            if(gamepad2.dpad_left)target =500;




            // Update motor powers based on gamepad inputs
            driveMotors(gamepad1);

            // PID control for the slider motor
            double pow = PIDcontrol(target, hardwareConfig.sliderMotor.getCurrentPosition());
            hardwareConfig.sliderMotor.setPower(pow);
            if(gamepad2.triangle)target=target+30;
            if(gamepad2.square)target=target-30;

            // Update telemetry data
            telemetry.addData("Servo Position", hardwareConfig.getMotorPosition());
            telemetry.addData("SliderPos", hardwareConfig.sliderMotor.getCurrentPosition());
            telemetry.addData("GrabL", hardwareConfig.grabL.getPosition());
            telemetry.addData("intakeservo", hardwareConfig.intakeGate);

            telemetry.update();
        }

        // Stop the camera at the end of OpMode
        camera.stopCamera();

        dashboard = FtcDashboard.getInstance();
    }

    private void driveMotors(Gamepad gamepad1) {
        float xr = gamepad1.right_stick_x;
        float ym = gamepad1.left_stick_y, xm = gamepad1.left_stick_x;
        double ltp = gamepad1.left_trigger;

        // Set motor powers for driving
        hardwareConfig.frontLeftMotor.setPower(-xm + ym - xr);
        hardwareConfig.backLeftMotor.setPower(xm + ym - xr);
        hardwareConfig.frontRightMotor.setPower(xm + ym + xr);
        hardwareConfig.backRightMotor.setPower(-xm + ym + xr);

        // Set powers for slider and intake
        hardwareConfig.sliderMotor.setPower(ltp * ltp * ltp);  // Adjust slider power

    }


    public double PIDcontrol(double reference, double state) {
        double error = reference - state;
        integralSum += error * timer.seconds();
        double derivative = (error - lastError) / timer.seconds();
        lastError = error;
        timer.reset();
        return (error * kp) + (derivative * kd) + (integralSum * ki);
    }
}
