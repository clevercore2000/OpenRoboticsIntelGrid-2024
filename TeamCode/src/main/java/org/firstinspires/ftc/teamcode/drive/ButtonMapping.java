package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
@Config
public class ButtonMapping {

    private HardwareConfiguration hardwareConfig;
    private BasicOpMode_Linear basicOpMode_linear;
    public static double grabClosed = 0;
    public static double grabOpen = 1;
    public boolean toggleGrab = false;
    public ButtonMapping(HardwareConfiguration hardwareConfig) {
        this.hardwareConfig = hardwareConfig;
    }


    public void handleGamepadInputs(Gamepad gamepad1, Gamepad gamepad2) {



        // Update intake gate position
        if (gamepad2.circle) {
            hardwareConfig.intakeGate.setPosition(1);


        }
        else hardwareConfig.intakeGate.setPosition(0);
        if(gamepad2.cross && !toggleGrab){hardwareConfig.intakeTubeSpin.setPosition(1); toggleGrab=true;}
        else if(gamepad2.cross && toggleGrab){hardwareConfig.intakeTubeSpin.setPosition(0.5); toggleGrab= false;}




        if(gamepad2.left_bumper ){
            hardwareConfig.grabR.setPosition(0.56);
            hardwareConfig.grabL.setPosition(0.56);

        }
        else if(gamepad2.right_bumper){

            hardwareConfig.grabR.setPosition(0.35);
            hardwareConfig.grabL.setPosition(0.35);



        }

        if(gamepad2.share) hardwareConfig.servoLock.setPosition(1);
        else hardwareConfig.servoLock.setPosition(0);



        if(gamepad2.options)hardwareConfig.stars.setPosition(0);
        else hardwareConfig.stars.setPosition(0.5);








    }
}
