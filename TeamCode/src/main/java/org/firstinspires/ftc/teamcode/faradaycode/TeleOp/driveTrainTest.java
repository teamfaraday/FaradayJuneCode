package org.firstinspires.ftc.teamcode.faradaycode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;
import org.firstinspires.ftc.teamcode.faradaycode.components.DriveTrainTeleOp;

@TeleOp(name = "driveTrainTest")
public class driveTrainTest extends OpModes {
    public DriveTrainTeleOp driveTrainTeleOp;

    public void runOpMode(){
        driveTrainTeleOp = new DriveTrainTeleOp(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !stopped){
            stopped = gamepad1.left_bumper && gamepad1.left_trigger > 0.6 && gamepad1.right_bumper && gamepad1.right_trigger > 0.6;
            NerfSlow.iterate(gamepad1.left_trigger, gamepad1.dpad_right, gamepad1.dpad_left);
            driveTrainTeleOp.iterate(gamepad1.left_stick_y, -gamepad1.right_stick_x, -gamepad1.left_stick_x);
        }
    }
}