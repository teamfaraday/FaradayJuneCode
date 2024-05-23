package org.firstinspires.ftc.teamcode.faradaycode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;
import org.firstinspires.ftc.teamcode.faradaycode.components.Claw;

@TeleOp(name = "TeleIsOpping")
public class TeleIsOpping extends OpModes {
    public void runOpMode(){
        //code here is setup like constants
        super.turnOn();

        //code past here will run once you start, so an init
        waitForStart();

        claw.openClaw(); //PLACEHOLDER! this is not what we need at this point!!

        //all code here will be continuously run during the execution
        while (opModeIsActive() && !stopped){
            //creates telem for nerf
            telemetry.addData("nerf", nerf);
            telemetry.update();

            //sets up slow vals and nerf vals + creates failsafe exit code
            isSlow = gamepad1.right_trigger > 0.6;
            nerf = Nerf.iterate(gamepad1.dpad_right, gamepad1.dpad_left);
            stopped = gamepad1.left_bumper && gamepad1.left_trigger > 0.6 && gamepad1.right_bumper && gamepad1.right_trigger > 0.6;

            //iterators, again PLACEHOLDER, PRANAV!
            claw.iterate(gamepad1.a, gamepad1.b);
            slides.iterate(gamepad1.dpad_up, gamepad1.dpad_down);
            //crServoSave.iterate(gamepad1.left_bumper, gamepad1.right_bumper);
            driveTrainTeleOp.iterate(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        }
    }
}