package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor


@TeleOp(name="2ndTeleOp")
class SecondTeleop: LinearOpMode(){


    override fun runOpMode(){
        val frontLeft = hardwareMap.get("frontLeft") as DcMotor
        val frontRight = hardwareMap.get("frontRight") as DcMotor
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor

        waitForStart()


        while(opModeIsActive()){

            
            Double y = gamepad1.left_stick_y


            frontLeft.power = 
            backLeft.power
            frontRight.power
            backRight.power




        }

    }
}