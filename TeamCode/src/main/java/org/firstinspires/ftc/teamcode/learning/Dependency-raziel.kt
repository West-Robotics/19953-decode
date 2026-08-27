package org.firstinspires.ftc.teamcode.learning

import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.HardwareMap

class `Dependency-raziel`(hardwareMap: HardwareMap) {

    val motor1 = hardwareMap.get("name") as DcMotorEx

    fun runMotor(){
        motor1.power = 1.0
    }

    fun stopMotor(){
        motor1.power = 0.0
    }
}