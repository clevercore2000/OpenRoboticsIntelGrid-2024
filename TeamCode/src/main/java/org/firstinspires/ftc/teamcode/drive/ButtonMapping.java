package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ButtonMapping {

    private HardwareConfiguration hardwareConfig;

    public ButtonMapping(HardwareConfiguration hardwareConfig) {
        this.hardwareConfig = hardwareConfig;
    }

    public void handleGamepadInputs(Gamepad gamepad1, Gamepad gamepad2) {



        // Update intake gate position
        if (gamepad1.dpad_right) {
            hardwareConfig.intakeGate.setPosition(1);
        } else {
            hardwareConfig.intakeGate.setPosition(0);
        }

        // Update grabber positions
        if (gamepad2.dpad_up) {
            hardwareConfig.grabR.setPosition(1);
            hardwareConfig.grabL.setPosition(1);
        } else if (gamepad2.dpad_down) {
            hardwareConfig.grabR.setPosition(0.47);
            hardwareConfig.grabL.setPosition(0.47);
        }

        // Update servo lock position
        if (gamepad1.left_bumper) {
            hardwareConfig.servoLock.setPosition(0);
        } else if (gamepad1.right_bumper) {
            hardwareConfig.servoLock.setPosition(1);
        } else {
            hardwareConfig.servoLock.setPosition(0.5);
        }

        // Update plate servo power
        if (gamepad1.square) {
            hardwareConfig.plateServo.setPower(1.0);
        } else if (gamepad1.circle) {
            hardwareConfig.plateServo.setPower(-1.0);
        } else {
            hardwareConfig.plateServo.setPower(0.0);
        }
    }
}
