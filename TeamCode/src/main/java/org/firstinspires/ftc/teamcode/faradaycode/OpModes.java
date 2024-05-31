package org.firstinspires.ftc.teamcode.faradaycode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.faradaycode.components.*;

public abstract class OpModes extends LinearOpMode{
    /*
    Control Hub
        Motors
            0: backLeft
            1: frontLeft
            2: slide2
            3: hang
        Servos
            0: drone
            1: purplePixel
    Expansion Hub
        Motors
            0: intakeA
            1: slide
            2: frontRight
            3: backRight
        Servos
            0: release
            1: intakeB1
            2: intakeB2
            3: rotate1
            4: rotate2 */

    public Claw claw;
    public Slides slides;
    // public DCMotorSave dcMotorSave;
    public DriveTrainTeleOp driveTrainTeleOp;

    public org.firstinspires.ftc.teamcode.faradaycode.components.Nerf Nerf = new Nerf();
    //public ElapsedTime timeSpent = new ElapsedTime();

    public boolean stopped = false;
    public static double nerf = 1;
    public static boolean isSlow = false;

    public void turnOn() {
        driveTrainTeleOp = new DriveTrainTeleOp(hardwareMap);
        claw = new Claw(hardwareMap);
        slides = new Slides(hardwareMap);
        //dcMotorSave = new DCMotorSave(hardwareMap); Not gotten to this yet

    }

}
