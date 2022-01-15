package com.team2073.robot;

import com.team2073.common.robot.AbstractRobotDelegate;

public class RobotDelegate extends AbstractRobotDelegate {
    private OperatorInterface oi;

    public RobotDelegate(double period) {
        super(period);
    }

    @Override
    public void robotInit() {
        oi = new OperatorInterface();
        oi.init();
    }

    @Override
    public void robotPeriodic() {
    }
}
