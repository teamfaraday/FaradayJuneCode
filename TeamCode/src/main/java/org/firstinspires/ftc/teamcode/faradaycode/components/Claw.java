package org.firstinspires.ftc.teamcode.faradaycode.components;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.faradaycode.*;

public class Claw implements deviceNames {

    //values for servo pos, modify as needed after testing
    public double servoOnePosOne = 1;
    public double servoOnePosTwo = 0;
    public double servoTwoPosOne = 1;
    public double servoTwoPosTwo = 0;


    //inits servo objects
    public Servo ServoOne;
    public Servo ServoTwo;

    //inits object and assigns servo names
    public Claw(HardwareMap hardwareMap) {
        ServoOne = hardwareMap.get(Servo.class, ServoOneName);
        ServoTwo = hardwareMap.get(Servo.class, ServoTwoName);
    }

    //what gets called
    public void iterate(boolean open, boolean close) {
        if (open) openClaw();
        if (close) closeClaw();
    }

    //functions
    //use 'OpModes.nerf' to grab nerf value for servo testing
    public void openClaw() {
        ServoOne.setPosition(servoOnePosOne);
        ServoTwo.setPosition(servoTwoPosOne);
    }
    public void closeClaw() {
        ServoOne.setPosition(servoOnePosTwo);
        ServoTwo.setPosition(servoTwoPosTwo);
    }
}
