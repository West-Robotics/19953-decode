package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp


@TeleOp(name="hehe")
class FirstTeleop: LinearOpMode(){

    override fun runOpMode(){
        val frontLeft = hardwareMap.get("frontLeft") as DcMotor
        val frontRight = hardwareMap.get("frontRight") as DcMotor
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor

        waitForStart()

        while(opModeIsActive()){
            frontRight.power = -gamepad1.left_stick_y.toDouble() - gamepad1.left_stick_x.toDouble() + gamepad1.right_stick_x.toDouble()
            frontLeft.power = -gamepad1.left_stick_y.toDouble() + gamepad1.left_stick_x.toDouble() - gamepad1.right_stick_x.toDouble()
            backLeft.power = -gamepad1.left_stick_y.toDouble() - gamepad1.left_stick_x.toDouble() - gamepad1.right_stick_x.toDouble()
            backRight.power = -gamepad1.left_stick_y.toDouble() + gamepad1.left_stick_x.toDouble() + gamepad1.right_stick_x.toDouble()



        }

    }
}