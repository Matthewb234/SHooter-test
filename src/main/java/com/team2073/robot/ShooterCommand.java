package com.team2073.robot;

import com.team2073.common.command.AbstractLoggingCommand;

public class ShooterCommand extends AbstractLoggingCommand {
    private ShooterTest shooterTest = new ShooterTest();

    @Override
    protected void executeDelegate() {
        shooterTest.setState(ShooterTest.ShooterState.SHOOT);
    }

    @Override
    protected void endDelegate() {
        shooterTest.setState(ShooterTest.ShooterState.STOP);
    }

    @Override
    protected boolean isFinishedDelegate() {
        return false;
    }
}
