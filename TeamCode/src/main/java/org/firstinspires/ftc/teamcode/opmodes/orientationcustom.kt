package org.firstinspires.ftc.teamcode.opmodes

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple

@Autonomous(name ="OrientationCustom")
class Autonomous: LinearOpMode() {
    override fun runOpMode() {
        val frontLeft = hardwareMap.get("frontLeft") as DcMotorEx
        val frontRight = hardwareMap.get("frontRight") as DcMotorEx
        val backLeft = hardwareMap.get("backLeft") as DcMotorEx
        val backRight = hardwareMap.get("backRight") as DcMotorEx

        frontLeft.direction = DcMotorSimple.Direction.REVERSE
        frontRight.direction = DcMotorSimple.Direction.FORWARD
        backLeft.direction = DcMotorSimple.Direction.REVERSE
        backRight.direction = DcMotorSimple.Direction.FORWARD

        val motors = mutableListOf<DcMotorEx>(frontLeft, frontRight, backLeft, backRight)
        for (motor in motors) {
            motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
            motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            motor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        }


        fun power(effort: Double) {
            for (motor in motors) {
                motor.power = effort
            }
        }

        fun moveForward(ticks: Int)
         {
            for (motor in motors) {
                motor.targetPosition = motor.currentPosition+ticks
            }
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.RUN_TO_POSITION
            }
            power(effort = 0.5)
            while (opModeIsActive() && (frontRight.isBusy || frontLeft.isBusy || backRight.isBusy || backLeft.isBusy)) {
                power(effort = 0.5)
            }
            power(effort = 0.0)
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
                motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            }

        }

        fun moveBackward(ticks: Int) {
            for (motor in motors) {
                motor.targetPosition = motor.currentPosition-ticks
            }
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.RUN_TO_POSITION
            }
            power(effort = 0.5)
            while (opModeIsActive() && (frontRight.isBusy || frontLeft.isBusy || backRight.isBusy || backLeft.isBusy)) {
                power(effort = 0.5)
            }
            power(effort = 0.0)
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
                motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            }

        }
        fun moveRight(ticks: Int) {
            frontLeft.targetPosition = frontLeft.currentPosition+ticks
            frontRight.targetPosition = frontRight.currentPosition-ticks
            backLeft.targetPosition = backLeft.currentPosition-ticks
            backRight.targetPosition = backRight.currentPosition+ticks
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.RUN_TO_POSITION
            }
            power(effort = 0.5)
            while (opModeIsActive() && (frontRight.isBusy || frontLeft.isBusy || backRight.isBusy || backLeft.isBusy)) {
                power(effort = 0.5)
            }
            power(effort = 0.0)
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
                motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            }

        }
        fun moveLeft(ticks: Int) {
            frontLeft.targetPosition = frontLeft.currentPosition-ticks
            frontRight.targetPosition = frontRight.currentPosition+ticks
            backLeft.targetPosition = backLeft.currentPosition+ticks
            backRight.targetPosition = backRight.currentPosition-ticks
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.RUN_TO_POSITION
            }
            power(effort = 0.5)
            while (opModeIsActive() && (frontRight.isBusy || frontLeft.isBusy || backRight.isBusy || backLeft.isBusy)) {
                power(effort = 0.5)
            }
            power(effort = 0.0)
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
                motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            }

        }

        waitForStart()
        //write code here commands are moveForward(), moveBackward(), moveLeft(), and moveRight()
        // example moveForward(1000)
        //1150 is about one tile
    }
}