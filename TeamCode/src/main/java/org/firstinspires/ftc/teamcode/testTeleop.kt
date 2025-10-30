package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotorSimple


@TeleOp(name="TestBotTime")
class testTeleop: LinearOpMode() {


    override fun runOpMode() {
        val frontLeft = hardwareMap.get("frontLeft") as DcMotor
        val frontRight = hardwareMap.get("frontRight") as DcMotor
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor

        backRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        backLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        frontRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        frontLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

        backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE


        backRight.direction = DcMotorSimple.Direction.REVERSE
        backLeft.direction = DcMotorSimple.Direction.FORWARD
        frontRight.direction = DcMotorSimple.Direction.REVERSE
        frontLeft.direction = DcMotorSimple.Direction.FORWARD

        waitForStart()

        while (opModeIsActive()) {


            val x = gamepad1.left_stick_x.toDouble() * 1.1
            val rx = gamepad1.right_stick_x.toDouble()
            val y = -gamepad1.left_stick_y.toDouble()

            while(opModeIsActive()){
                frontRight.power =  y - x + rx
                frontLeft.power =  y + x - rx
                backLeft.power =  y - x - rx
                backRight.power =  y + x + rx



            }


        }
    }
}
