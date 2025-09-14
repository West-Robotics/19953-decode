package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor

@TeleOp(name="2ndTeleOp")

class secondTeleop: LinearOpMode(){

    override fun runOpMode(){
        val frontLeft = hardwareMap.get("frontLeft") as DcMotor
        val frontRight = hardwareMap.get("frontRight") as DcMotor
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor

        waitForStart()

        while(opModeIsActive()){
            if (gamepad1.a){
                frontLeft.power = 1.0
                frontRight.power = 1.0
                backLeft.power = 1.0
                backRight.power = 1.0
            } else {
                frontLeft.power = 0.0
                frontRight.power = 0.0
                backLeft.power = 0.0
                backRight.power = 0.0
            }

            if (gamepad1.x){
                frontRight.power = 1.0
                frontLeft.power = -1.0
                backLeft.power = 1.0
                backRight.power = 1.0
            } else {
                frontLeft.power = 0.0
                frontRight.power = 0.0
                backLeft.power = 0.0
                backRight.power = 0.0
            }

            if (gamepad1.b){
                backLeft.power = 1.0
                frontRight.power = 1.0
                backLeft.power = 1.0
                backRight.power = -1.0
            } else {
                frontLeft.power = 0.0
                frontRight.power = 0.0
                backLeft.power = 0.0
                backRight.power = 0.0
            }

            if (gamepad1.y){
                frontLeft.power = -1.0
                frontRight.power = -1.0
                backLeft.power = -1.0
                backRight.power = -1.0
            } else {
                frontLeft.power = 0.0
                frontRight.power = 0.0
                backLeft.power = 0.0
                backRight.power = 0.0
            }

        }

    }
}