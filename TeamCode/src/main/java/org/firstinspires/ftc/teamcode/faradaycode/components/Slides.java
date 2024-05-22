package org.firstinspires.ftc.teamcode.faradaycode.components;

import android.transition.Slide;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.faradaycode.*;

public class Slides implements  deviceNames{

    //speeds for rotation
    public double power1 = 1;
    public double power2 = -1;

    //amnt to slow smth down by
    public double slowConst = 0.5;

    //inits motor objects
    //public DcMotor dummyDCMotor;
    public DcMotor LeftSlide;

    //inits object and assigns servo names
    public Slides(HardwareMap hardwareMap) {
        LeftSlide = hardwareMap.dcMotor.get(SlideLName);
    }

    //when called, parse through for motion
    public void iterate(boolean forward, boolean reverse) {
        if (forward) {
            activate();
        } else if (reverse) {
            reverse();
        } else{
            deactivate();
        }
    }

    //functions
    public void activate() {
        dummyDCMotor.setPower(power1 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
    }
    public void deactivate() {
        dummyDCMotor.setPower(0);
    }
    public void reverse() {
        dummyDCMotor.setPower(power2 * OpModes.nerf * ((OpModes.isSlow) ? slowConst: 1));
    }
}
