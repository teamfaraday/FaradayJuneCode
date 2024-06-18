package org.firstinspires.ftc.teamcode.faradaycode.components;

import android.transition.Slide;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.faradaycode.*;

public class Slides implements  deviceNames{

    //speeds for rotation
    public double power1 = 0.7;
    public double power2 = -1;
    public double antiGravPower = 0.13;

    //amnt to slow smth down by
    public double slowConst = 0.5;

    //inits motor objects
    //public DcMotor dummyDCMotor;
    public DcMotor leftSlide;
    public DcMotor rightSlide;

    //inits object and assigns servo names
    public Slides(HardwareMap hardwareMap) {
        leftSlide = hardwareMap.dcMotor.get(slideLName);
        rightSlide = hardwareMap.dcMotor.get(slideRName);
    }

    //when called, parse through for motion
    public void iterate(boolean down, boolean up) {
        if (up) {
            activate();
        } else if (down) {
            reverse();
        } else{
            deactivate();
        }
    }

    //functions
    public void activate() {
        leftSlide.setPower(power1 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: OpModes.slowAmnt));
        rightSlide.setPower(-power1 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: OpModes.slowAmnt));

    }
    public void deactivate() {
        leftSlide.setPower(antiGravPower);
        rightSlide.setPower(-antiGravPower);
    }
    public void reverse() {
        leftSlide.setPower(power2 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: OpModes.slowAmnt));
        rightSlide.setPower(-power2 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: OpModes.slowAmnt));
    }
}
