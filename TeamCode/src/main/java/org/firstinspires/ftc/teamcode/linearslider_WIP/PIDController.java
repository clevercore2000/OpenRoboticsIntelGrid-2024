package org.firstinspires.ftc.teamcode.linearslider_WIP;


public class PIDController {
    private double kp, ki, kd;
    private double setPoint;
    private double integral = 0;
    private double lastError = 0;
    public static final int LOW_POSITION = 0;
    public static final int MEDIUM_POSITION = 500;
    public static final int HIGH_POSITION = 1000;

    public PIDController(double kp, double ki, double kd, double setPoint) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.setPoint = setPoint;
    }

    public double compute(double currentPosition, double deltaTime) {
        double error = setPoint - currentPosition;
        integral += error * deltaTime;
        double derivative = (error - lastError) / deltaTime;

        double output = kp * error + ki * integral + kd * derivative;

        lastError = error;
        return output;
    }

    public void setSetPoint(double setPoint) {
        this.setPoint = setPoint;
    }
}
