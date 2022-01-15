package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.team2073.common.robot.RobotApplication;

public class Main {
    public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
        RobotApplication.start(() ->new RobotDelegate(.01));
    }
}