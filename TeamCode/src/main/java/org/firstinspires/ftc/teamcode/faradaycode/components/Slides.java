package org.firstinspires.ftc.teamcode.faradaycode.components;

import android.transition.Slide;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.faradaycode.*;

public class Slides implements  deviceNames{

    //speeds for rotation
    public double power1 = 0.7;
    public double power2 = -1;

    //amnt to slow smth down by
    public double slowConst = 0.5;

    //inits motor objects
    //public DcMotor dummyDCMotor;
    public DcMotor LeftSlide;
    public DcMotor RightSlide;

    //inits object and assigns servo names
    public Slides(HardwareMap hardwareMap) {
        LeftSlide = hardwareMap.dcMotor.get(SlideLName);
        RightSlide = hardwareMap.dcMotor.get(SlideRName);
    }

    //when called, parse through for motion
    public void iterate(boolean up, boolean down) {
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
        LeftSlide.setPower(power1 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
        RightSlide.setPower(-power1 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
    }
    public void deactivate() {
        LeftSlide.setPower(0);
        RightSlide.setPower(0);
    }
    public void reverse() {
        LeftSlide.setPower(power2 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
        RightSlide.setPower(-power2 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
    }
}
