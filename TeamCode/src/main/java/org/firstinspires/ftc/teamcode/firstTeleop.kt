package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp


@TeleOp(name="hehe")
class firstTeleop: LinearOpMode(){

    override fun runOpMode(){
        val frontLeft = hardwareMap.get("frontLeft") as DcMotor
        val frontRight = hardwareMap.get("frontRight") as DcMotor
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor

        waitForStart()

        while(opModeIsActive()){
            if (gamepad1.a){
                frontLeft.power = 1.0
            } else {
                frontLeft.power = 0.0
            }
        }

    }
}