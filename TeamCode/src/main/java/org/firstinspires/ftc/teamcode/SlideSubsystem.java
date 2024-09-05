package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class SlideSubsystem extends SubsystemBase {
    public Motor slideMotor;
    public Motor rightSlideMotor;
    private int slideLevel4Pos = 250;
    private int slideLevel3Pos = 200;
    private int slideLevel2Pos = 150;
    private int slideLevel1Pos = 100;
    private int slideMaxExtend = 350;
    private int slideIntermediate = 1200;
    private int homePos = 10;
    public boolean slideMoving = false;

    public SlideSubsystem(Motor slideMotor, Motor rightSlideMotor) {
        this.slideMotor = slideMotor;
    }

    public void slideHome() {
        // set the run mode
        slideMoving = true;
        slideMotor.setRunMode(Motor.RunMode.PositionControl);
        rightSlideMotor.setRunMode(Motor.RunMode.PositionControl);

        // set the target position
        slideMotor.setTargetPosition(homePos); // an integer representing desired tick count
        rightSlideMotor.setTargetPosition(homePos);

        slideMotor.set(0);
        rightSlideMotor.set(0);

        // set the tolerance
        slideMotor.setPositionTolerance(13.6);   // allowed maximum error
        rightSlideMotor.setPositionTolerance(13.6);

        // perform the control loop
        while (!slideMotor.atTargetPosition()) {
            slideMotor.set(1);
            rightSlideMotor.set(1);
        }

        slideMotor.stopMotor();
        rightSlideMotor.stopMotor();// stop the motor
    }

    public void slideLevel4() {
        // set the run mode
        slideMoving = true;
        slideMotor.setRunMode(Motor.RunMode.PositionControl);

        // set the target position
        slideMotor.setTargetPosition(slideLevel4Pos); // an integer representing desired tick count

        slideMotor.set(0);

        // set the tolerance
        slideMotor.setPositionTolerance(13.6);   // allowed maximum error

        // perform the control loop
        while (!slideMotor.atTargetPosition()) {
            slideMotor.set(1);
        }
        slideMotor.stopMotor(); // stop the motor
    }

    public void slideLevel3() {
        // set the run mode
        slideMoving = true;
        slideMotor.setRunMode(Motor.RunMode.PositionControl);

        // set the target position
        slideMotor.setTargetPosition(slideLevel3Pos); // an integer representing desired tick count

        slideMotor.set(0);

        // set the tolerance
        slideMotor.setPositionTolerance(13.6);   // allowed maximum error

        // perform the control loop
        while (!slideMotor.atTargetPosition()) {
            slideMotor.set(1);
        }
        slideMotor.stopMotor(); // stop the motor
    }

    public void slideLevel2() {
        // set the run mode
        slideMoving = true;
        slideMotor.setRunMode(Motor.RunMode.PositionControl);

        // set and get the position coefficient
        slideMotor.setPositionCoefficient(0.05);

        double leftkP = slideMotor.getPositionCoefficient();

        // set the target position
        slideMotor.setTargetPosition(slideLevel2Pos); // an integer representing desired tick count

        slideMotor.set(0);

        // set the tolerance
        slideMotor.setPositionTolerance(13.6);   // allowed maximum error

        // perform the control loop
        while (!slideMotor.atTargetPosition()) {
            slideMotor.set(1);
        }
        slideMotor.stopMotor(); // stop the motor
    }

    public void slideLevel1() {
        // set the run mode
        slideMoving = true;
        slideMotor.setRunMode(Motor.RunMode.PositionControl);

        // set and get the position coefficient
        slideMotor.setPositionCoefficient(0.05);

        double leftkP = slideMotor.getPositionCoefficient();

        // set the target position
        slideMotor.setTargetPosition(slideLevel1Pos); // an integer representing desired tick count

        slideMotor.set(0);

        // set the tolerance
        slideMotor.setPositionTolerance(13.6);   // allowed maximum error

        // perform the control loop
        while (!slideMotor.atTargetPosition()) {
            slideMotor.set(1);

        }
        slideMotor.stopMotor(); // stop the motor
    }

    public void slideMaxExtended() {
        // set the run mode
        slideMoving = true;
        slideMotor.setRunMode(Motor.RunMode.PositionControl);

        // set the target position
        slideMotor.setTargetPosition(slideMaxExtend); // an integer representing desired tick count

        slideMotor.set(0);

        // set the tolerance
        slideMotor.setPositionTolerance(13.6);   // allowed maximum error

        // perform the control loop
        while (!slideMotor.atTargetPosition()) {
            slideMotor.set(1);
        }

        slideMotor.stopMotor(); // stop the motor
    }

    public void slideIntermediate() {
        // set the run mode
        slideMoving = true;
        slideMotor.setRunMode(Motor.RunMode.PositionControl);
        rightSlideMotor.setRunMode(Motor.RunMode.PositionControl);

        // set and get the position coefficient
        slideMotor.setPositionCoefficient(0.05);
        rightSlideMotor.setPositionCoefficient(0.05);

        double leftkP = slideMotor.getPositionCoefficient();
        double rightkP = rightSlideMotor.getPositionCoefficient();

        // set the target position
        slideMotor.setTargetPosition(slideIntermediate); // an integer representing desired tick count
        rightSlideMotor.setTargetPosition(slideIntermediate);

        slideMotor.set(0);
        rightSlideMotor.set(0);

        // set the tolerance
        slideMotor.setPositionTolerance(13.6);   // allowed maximum error
        rightSlideMotor.setPositionTolerance(13.6);

        // perform the control loop
        while (!slideMotor.atTargetPosition()) {
            slideMotor.set(1);
            rightSlideMotor.set(1);
        }
        slideMotor.stopMotor();
        rightSlideMotor.stopMotor();// stop the motor
    }
}