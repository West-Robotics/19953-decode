package org.firstinspires.ftc.teamcode.learning

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap

class Dependencynick (
    hardwareMap: HardwareMap,
) {
    val frontRight = hardwareMap.get("frontRight") as DcMotorEx
    val frontLeft = hardwareMap.get("frontLeft") as DcMotorEx
    val backRight = hardwareMap.get("backRight") as DcMotorEx
    val backLeft = hardwareMap.get("backLeft") as DcMotorEx
    init {
        frontRight.direction = DcMotorSimple.Direction.FORWARD
        frontLeft.direction = DcMotorSimple.Direction.FORWARD
        backRight.direction = DcMotorSimple.Direction.REVERSE
        backLeft.direction = DcMotorSimple.Direction.REVERSE

        frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE


    }

    fun runMotor(){
        frontRight.power = 1.0
        frontLeft.power = 1.0
        backRight.power = 1.0
        backLeft.power = 1.0

    }

    fun stopMotor(){
        frontRight.power = 0.0
        frontLeft.power = 0.0
        backRight.power = 0.0
        backLeft.power = 0.0
    }
}