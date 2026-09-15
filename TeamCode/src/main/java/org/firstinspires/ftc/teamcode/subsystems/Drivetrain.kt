package org.firstinspires.ftc.teamcode.subsystems
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import kotlin.math.abs
import kotlin.math.max
    class Drivetrain(hardwareMap: HardwareMap) { // this is not what most drivetrains look like this one can because of the ScMotor class
        val frontRight = ScMotor(hardwareMap, "frontRight", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)
        val frontLeft = ScMotor(hardwareMap, "frontLeft", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)
        val backRight = ScMotor(hardwareMap, "backRight", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)
        val backLeft = ScMotor(hardwareMap, "backLeft", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)
    fun setSpeed(x: Double, y: Double, turn: Double) { //driving math
        val denominator = max(abs(y) + abs(x) + abs(turn), 1.0)
        frontRight.effort = (y - x - turn) / denominator // (right side: -turn)
        frontLeft.effort = (y + x + turn) / denominator // (left side: +turn)
        backRight.effort = (y + x - turn) / denominator // (right side: -turn)
        backLeft.effort = (y - x + turn) / denominator // (left side: +turn)
    }
    fun write() { // speeds stuff up
        frontRight.write()
        frontLeft.write()
        backRight.write()
        backLeft.write()
    } }