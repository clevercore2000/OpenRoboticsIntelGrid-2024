
package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareConfiguration {

    // Declare hardware components
    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backRightMotor;
    public DcMotor sliderMotor;
    public DcMotor intakeMotor;

    public Servo intakeGate;
    public CRServo plateServo;
    public Servo grabR;
    public Servo grabL;
    public Servo servoLock;

    public HardwareConfiguration(HardwareMap hardwareMap) {
        // Map hardware components
        frontLeftMotor = hardwareMap.dcMotor.get("leftFront");
        backLeftMotor = hardwareMap.dcMotor.get("leftBack");
        frontRightMotor = hardwareMap.dcMotor.get("rightFront");
        backRightMotor = hardwareMap.dcMotor.get("rightBack");
        sliderMotor = hardwareMap.dcMotor.get("SliderMotor");
        intakeMotor = hardwareMap.dcMotor.get("IntakeMotor");

        intakeGate = hardwareMap.get(Servo.class, "intakeGate2");
        plateServo = hardwareMap.get(CRServo.class, "serv2");
        grabR = hardwareMap.get(Servo.class, "grabRight");
        grabL = hardwareMap.get(Servo.class, "grabLeft");
        servoLock = hardwareMap.get(Servo.class, "serv1");

        /** Configure motors**/
        //Brakes
        sliderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //Reverse(ma doare capu)
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        grabR.setDirection(Servo.Direction.REVERSE);
    }

    public void initializePositions() {
        servoLock.setPosition(0.5);
    }

    public double getMotorPosition() {
        return servoLock.getPosition();
    }

}
