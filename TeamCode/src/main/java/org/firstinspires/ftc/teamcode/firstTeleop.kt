package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode

class firstTeleop: LinearOpMode(){

    override fun runOpMode(){
        val frontLeft = hardwareMap.get("frontLeft")
        val frontRight = hardwareMap.get("frontRight")
        val backLeft = hardwareMap.get("backLeft")
        val backRight = hardwareMap.get("backRight")
    }
}