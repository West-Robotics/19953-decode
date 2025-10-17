package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor


@TeleOp(name="PushBot")
class SecondTeleop: LinearOpMode() {


    override fun runOpMode() {
        val frontLeft = hardwareMap.get("frontLeft") as DcMotor
        val frontRight = hardwareMap.get("frontRight") as DcMotor
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor

        waitForStart()


        while (opModeIsActive()) {


            val x = gamepad1.left_stick_x.toDouble() * 1.1
            val rx = gamepad1.right_stick_x.toDouble()
            val y = -gamepad1.left_stick_y.toDouble()

            while (opModeIsActive()) {
                frontRight.power = y - x + rx
                frontLeft.power = y + x - rx
                backLeft.power = y - x - rx
                backRight.power = y + x + rx


            }

        }
    }
}