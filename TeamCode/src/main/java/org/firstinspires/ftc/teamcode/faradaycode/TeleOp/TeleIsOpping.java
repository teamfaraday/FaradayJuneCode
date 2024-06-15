package org.firstinspires.ftc.teamcode.faradaycode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

@TeleOp(name = "TeleIsOpping")
public class TeleIsOpping extends OpModes {
    public void runOpMode(){
        super.turnOn();


        waitForStart();

        //claw.openClaw();

        while (opModeIsActive() && !stopped){
            telemetry.addData("nerf", nerf);
            telemetry.update();

            NerfSlow.iterate(gamepad1.left_trigger, gamepad1.dpad_right, gamepad1.dpad_left);
            stopped = gamepad1.left_bumper && gamepad1.left_trigger > 0.6 && gamepad1.right_bumper && gamepad1.right_trigger > 0.6;

            //claw.iterate(gamepad1.a, gamepad1.b);
            slides.iterate(gamepad1.left_bumper, gamepad1.right_bumper);
            driveTrainTeleOp.iterate(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        }
    }
}