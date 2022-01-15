package com.team2073.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.team2073.common.periodic.AsyncPeriodicRunnable;

public class ShooterTest implements AsyncPeriodicRunnable {
    private CANSparkMax motor1 = new CANSparkMax(7, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax motor2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax motor3 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);

    private double MAX_VELOCITY = 11000/10d;
    private ShooterState state = ShooterState.STOP;

    public ShooterTest() {
        autoRegisterWithPeriodicRunner(20);
        motor1.setOpenLoopRampRate(.125);
        motor2.setOpenLoopRampRate(.125);
        motor3.setOpenLoopRampRate(.125);
        motor1.setInverted(false);
        motor2.setInverted(false);
        motor3.setInverted(false);
    }

    @Override
    public void onPeriodicAsync() {
        setPower(state.getBottomRPM(), state.getTopRPM());
    }

    private void setPower(Double RPM, Double RPMHigh) {
        motor1.set(RPM/MAX_VELOCITY);
//        motor2.set(RPM/MAX_VELOCITY);
//        motor3.set(RPMHigh/MAX_VELOCITY);
    }

    public void setState(ShooterState state){
        this.state = state;
    }

    public enum ShooterState {
        SHOOT(5000, 5000),
        STOP(0d, 0d);

        private double TopRPM;
        private double BottomRPM;

        ShooterState(double TopRPM, double BottomRPM){
            this.TopRPM = TopRPM;
            this.BottomRPM = BottomRPM;
        }

        public double getBottomRPM() {
            return BottomRPM;
        }

        public double getTopRPM() {
            return TopRPM;
        }
    }

}