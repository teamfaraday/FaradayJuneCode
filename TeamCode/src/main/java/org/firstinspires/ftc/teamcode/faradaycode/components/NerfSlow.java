package org.firstinspires.ftc.teamcode.faradaycode.components;

import org.firstinspires.ftc.teamcode.faradaycode.OpModes;

public class NerfSlow {

    //constants
    double nerfInc = 0.0001;
    boolean isHeldDown = false;

    //iterates
    public void iterate(double slowVal, boolean increase, boolean decrease) {
        isHeldDown = (increase || decrease);
        OpModes.nerf += (increase) ? nerfInc : ((decrease) ? -nerfInc : 0);
        OpModes.slowAmnt = 1 - slowVal;
        //OpModes.isSlow = slowVal >= 0.6;
    }

}