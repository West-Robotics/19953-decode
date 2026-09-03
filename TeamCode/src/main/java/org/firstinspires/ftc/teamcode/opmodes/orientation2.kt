package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.HardwareMap

@TeleOp(name = "orientation2")
class orientation2: LinearOpMode() {

    override fun runOpMode() {
        val frontLeft = hardwareMap.get("topLeft") as DcMotorEx
        val frontRight = hardwareMap.get("topRight") as DcMotorEx
        val bottomLeft = hardwareMap.get("bottomLeft") as DcMotorEx
        val bottomRight = hardwareMap.get("bottomRight") as DcMotorEx

        frontLeft.direction = DcMotorSimple.Direction.REVERSE
        frontRight.direction = DcMotorSimple.Direction.FORWARD
        bottomLeft.direction = DcMotorSimple.Direction.REVERSE
        bottomRight.direction = DcMotorSimple.Direction.FORWARD

        val motors = mutableListOf<DcMotorEx>(frontLeft, frontRight, bottomLeft, bottomRight)
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

        fun moveForward() {
            for (motor in motors) {
                motor.targetPosition = 1050
            }
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.RUN_TO_POSITION
            }
            power(effort = 0.5)
            while (opModeIsActive() && (frontRight.isBusy || frontLeft.isBusy || bottomRight.isBusy || bottomLeft.isBusy)) {
                telemetry.addData("frontright",frontRight.currentPosition)
                telemetry.addData("frontleft",frontLeft.currentPosition)
                telemetry.addData("backleft",bottomLeft.currentPosition)
                telemetry.addData("backright",bottomRight.currentPosition)
                telemetry.update()
            }
            power(effort = 0.0)
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
                motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            }

        }

        fun moveBackward() {
            for (motor in motors) {
                motor.targetPosition = -1050
            }
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.RUN_TO_POSITION
            }
            power(effort = 0.5)
            while (opModeIsActive() && (frontRight.isBusy || frontLeft.isBusy || bottomRight.isBusy || bottomLeft.isBusy)) {
                power(effort = 0.5)
            }
            power(effort = 0.0)
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
                motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            }

        }

        fun moveRight() {
            frontLeft.targetPosition = 1050
            frontRight.targetPosition = -1050
            bottomLeft.targetPosition = -1050
            bottomRight.targetPosition = 1050
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.RUN_TO_POSITION
            }
            power(effort = 0.5)
            while (opModeIsActive() && (frontRight.isBusy || frontLeft.isBusy || bottomRight.isBusy || bottomLeft.isBusy)) {
                telemetry.addData("frontright",frontRight.currentPosition)
                telemetry.addData("frontleft",frontLeft.currentPosition)
                telemetry.addData("backleft",bottomLeft.currentPosition)
                telemetry.addData("backright",bottomRight.currentPosition)
                telemetry.update()
            }
            power(effort = 0.0)
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
                motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            }

        }

        fun moveLeft() {
            frontLeft.targetPosition = -1050
            frontRight.targetPosition = 1050
            bottomLeft.targetPosition = 1050
            bottomRight.targetPosition = -1050
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.RUN_TO_POSITION
            }
            power(effort = 0.5)
            while (opModeIsActive() && (frontRight.isBusy || frontLeft.isBusy || bottomRight.isBusy || bottomLeft.isBusy)) {
                power(effort = 0.5)
            }
            power(effort = 0.0)
            for (motor in motors) {
                motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
                motor.mode = DcMotor.RunMode.RUN_USING_ENCODER
            }

        }

        waitForStart()
        moveForward() 


    }
}


