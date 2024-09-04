//package org.firstinspires.ftc.teamcode;
//
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//
//@TeleOp
//public class DriveTest extends LinearOpMode {
//    @Override
//    public void runOpMode() throws InterruptedException {
//        // Declare our motors
//        // Make sure your ID's match your configuration
//        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("leftFront");
//        DcMotor backLeftMotor = hardwareMap.dcMotor.get("leftBack");
//        DcMotor frontRightMotor = hardwareMap.dcMotor.get("rightFront");
//        DcMotor backRightMotor = hardwareMap.dcMotor.get("rightBack");
//
//        // Reverse the right side motors. This may be wrong for your setup.
//        // If your robot moves backwards when commanded to go forwards,
//        // reverse the left side instead.
//        // See the note about this earlier on this page.
//        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        waitForStart();
//
//        if (isStopRequested()) return;
//
//        while (opModeIsActive()) {
//            double horizontal = gamepad1.left_stick_y; // Remember, Y stick value is reversed
//            double vertical = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
//            double pivot = gamepad1.right_stick_x;
//
//            // Denominator is the largest motor power (absolute value) or 1
//            // This ensures all the powers maintain the same ratio,
//            // but only if at least one is out of the range [-1, 1]
//            double denominator = Math.max(Math.abs(horizontal) + Math.abs(vertical) + Math.abs(pivot), 1);
//            double frontLeftPower = (horizontal + vertical + pivot) / denominator;
//            double backLeftPower = (horizontal - vertical + pivot) / denominator;
//            double frontRightPower = (horizontal - vertical - pivot) / denominator;
//            double backRightPower = (horizontal + vertical - pivot) / denominator;
//
//            frontLeftMotor.setPower(frontLeftPower*frontLeftPower*frontLeftPower*0.7);
//            backLeftMotor.setPower(backLeftPower*backLeftPower*backLeftPower*0.7);
//            frontRightMotor.setPower(frontRightPower*frontRightPower*frontRightPower*0.7);
//            backRightMotor.setPower(backRightPower*backRightPower*backRightPower*0.7);
//        }
//    }
//}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DriveTest extends LinearOpMode {
    public MecanumDrive robot = new MecanumDrive();

    @Override
    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);
    }

}







