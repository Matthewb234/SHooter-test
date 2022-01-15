package com.team2073.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface {
    private Joystick controller = new Joystick(1);

    private JoystickButton a = new JoystickButton(controller, 1);

    public OperatorInterface(){
    }

    public void init() {
        a.whileHeld(new ShooterCommand());
    }
}
