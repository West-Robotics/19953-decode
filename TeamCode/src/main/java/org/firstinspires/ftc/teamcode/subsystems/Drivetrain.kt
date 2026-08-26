package org.firstinspires.ftc.teamcode.subsystems

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import kotlin.math.abs
import kotlin.math.max

    class Drivetrain(hardwareMap: HardwareMap) {


    // Index order: 0 = topRight, 1 = bottomRight, 2 = bottomLeft, 3 = topLeft
    private val motors = arrayOf(
        ScMotor(hardwareMap, "topRight", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE), // 0: topRight
        ScMotor(hardwareMap, "bottomRight", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE),  // 1: bottomRight
        ScMotor(hardwareMap, "bottomLeft", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE),   // 2: bottomLeft
        ScMotor(hardwareMap, "topLeft", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)   // 3: topLeft
    )

    fun setSpeed(x: Double, y: Double, turn: Double) {
        val denominator = max(abs(y) + abs(x) + abs(turn), 1.0)
        motors[0].effort = (y - x - turn) / denominator // topRight   (right side: -turn)
        motors[1].effort = (y + x - turn) / denominator // bottomRight (right side: -turn)
        motors[2].effort = (y - x + turn) / denominator // bottomLeft  (left side: +turn)
        motors[3].effort = (y + x + turn) / denominator // topLeft    (left side: +turn)
    }

    fun write() {
        for (motor in motors) {
            motor.write()
        }
    }
}