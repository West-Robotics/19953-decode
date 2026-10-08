package org.firstinspires.ftc.teamcode.subsystems
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import kotlin.math.abs
import kotlin.math.max
    class Drivetrain(hardwareMap: HardwareMap) { // pulls the ScMotor class to shorten this
        val frontRight = ScMotor(hardwareMap, "frontRight", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)
        val frontLeft = ScMotor(hardwareMap, "frontLeft", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)
        val backRight = ScMotor(hardwareMap, "backRight", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)
        val backLeft = ScMotor(hardwareMap, "backLeft", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)
    fun setSpeed(x: Double, y: Double, turn: Double) { //driving math
        val denominator = max(abs(y) + abs(x) + abs(turn), 1.0)
//        frontRight.effort = (y - x - turn) / denominator // check gm0 drivetrain to get more indepth about this
//        frontLeft.effort = (y + x + turn) / denominator
//        backRight.effort = (y + x - turn) / denominator
//        backLeft.effort = (y - x + turn) / denominator
        frontRight.effort = (y + x + turn) / denominator // check gm0 drivetrain to get more indepth about this
        frontLeft.effort = (y - x - turn) / denominator
        backRight.effort = (y - x + turn) / denominator
        backLeft.effort = (y + x - turn) / denominator
    }
    fun write() { // speeds stuff up
        frontRight.write()
        frontLeft.write()
        backRight.write()
        backLeft.write()
    } }