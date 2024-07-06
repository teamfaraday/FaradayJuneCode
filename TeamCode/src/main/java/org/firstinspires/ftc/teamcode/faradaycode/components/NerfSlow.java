package org.firstinspires.ftc.teamcode.faradaycode.components;

import android.graphics.Path;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

public class NerfSlow {

    //constants
    double nerfInc = 0.0001;

    //iterates
    public void iterate(boolean slowVal, boolean increase, boolean decrease) {
        OpModes.nerf += (increase) ? nerfInc : ((decrease) ? -nerfInc : 0);

        //OpModes.slowAmnt = 1 - slowVal;
        OpModes.isSlow = slowVal;
    }

}