package org.firstinspires.ftc.teamcode.faradaycode.components;

import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.teamcode.faradaycode.*;

public class DriveTrainTeleOp implements deviceNames{

    //constants
    public double powerRange = 1;
    public double slowConst = 0.45;

    //inits motor objects
    public DcMotor fL;
    public DcMotor fR;
    public DcMotor bL;
    public DcMotor bR;


    //inits the object + names
    public DriveTrainTeleOp(HardwareMap hardwareMap) {
        fL = hardwareMap.get(DcMotor.class, leftFrontName);
        fR = hardwareMap.get(DcMotor.class, rightFrontName);
        bL = hardwareMap.get(DcMotor.class, leftRearName);
        bR = hardwareMap.get(DcMotor.class, rightRearName);
        motorInits();
    }

    //sets motors based on teleop vals given
    public void iterate(double y, double x, double rx) {
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), powerRange);
        double frontLeftPower = ((y - x - rx)) / denominator;
        double backLeftPower = ((y + x - rx)) / denominator;
        double frontRightPower = ((y + x + rx)) / denominator;
        double backRightPower = ((y - x + rx)) / denominator;
        fL.setPower(frontLeftPower * OpModes.nerf * ((OpModes.isSlow) ? slowConst : OpModes.slowAmnt));
        bL.setPower(backLeftPower * OpModes.nerf * ((OpModes.isSlow) ? slowConst : OpModes.slowAmnt));
        fR.setPower(frontRightPower * OpModes.nerf * ((OpModes.isSlow) ? slowConst : OpModes.slowAmnt));
        bR.setPower(backRightPower * OpModes.nerf * ((OpModes.isSlow) ? slowConst : OpModes.slowAmnt));
    }

    //set up motors
    public void motorInits() {
        fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.FORWARD);
        bL.setDirection(DcMotor.Direction.FORWARD);
        fL.setDirection(DcMotor.Direction.FORWARD);
    }
    //use only for RR
    public void autonDirs() {
        fR.setDirection(DcMotor.Direction.FORWARD);
        bR.setDirection(DcMotor.Direction.FORWARD);
        bR.setDirection(DcMotor.Direction.FORWARD);
        bR.setDirection(DcMotor.Direction.FORWARD);
    }
}