package org.firstinspires.ftc.teamcode.faradaycode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;
import org.firstinspires.ftc.teamcode.faradaycode.components.DCMotorSave;
import org.firstinspires.ftc.teamcode.faradaycode.components.DriveTrainTeleOp;

@TeleOp(name = "sk")
public class skibidiMotor extends OpModes {
    public DCMotorSave dcMotorSave;

    public void runOpMode(){
        dcMotorSave = new DCMotorSave(hardwareMap);

        waitForStart();

        //dcMotorSave.encoderRun(100);
        while (opModeIsActive() && !stopped){
            isSlow = gamepad1.right_trigger > 0.6;
            dcMotorSave.iterate(gamepad1.a, gamepad1.b);
        }
    }
}