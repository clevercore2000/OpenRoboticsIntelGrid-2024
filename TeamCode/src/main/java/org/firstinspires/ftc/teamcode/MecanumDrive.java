package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive {
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    HardwareMap hardwareMap;

    public void init(HardwareMap hwareMap) {
        DcMotor leftFront = hardwareMap.dcMotor.get("leftFront");
        DcMotor leftBack = hardwareMap.dcMotor.get("leftBack");
        DcMotor rightFront = hardwareMap.dcMotor.get("rightFront");
        DcMotor rightBack = hardwareMap.dcMotor.get("rightBack");

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void moveRobot(double horizontal, double vertical, double pivot){
        double denominator = Math.max(Math.abs(horizontal) + Math.abs(vertical) + Math.abs(pivot), 1);
        double frontLeftPower = (horizontal + vertical + pivot) / denominator;
        double backLeftPower = (horizontal - vertical + pivot) / denominator;
        double frontRightPower = (horizontal - vertical - pivot) / denominator;
        double backRightPower =  (horizontal + vertical - pivot) / denominator;

        leftFront.setPower(frontLeftPower*frontLeftPower*frontLeftPower*0.7);
        leftBack.setPower(backLeftPower*backLeftPower*backLeftPower*0.7);
        rightFront.setPower(frontRightPower*frontRightPower*frontRightPower*0.7);
        rightBack.setPower(backRightPower*backRightPower*backRightPower*0.7);
    }

}
