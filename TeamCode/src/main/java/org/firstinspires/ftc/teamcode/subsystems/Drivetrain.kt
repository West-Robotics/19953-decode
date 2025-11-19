package org.firstinspires.ftc.teamcode.subsystems
//import com.qualcomm.robotcore.hardware.external.Telemetry
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.HardwareMap
import kotlin.math.abs
import kotlin.math.max

class Drivetrain(hardwareMap: HardwareMap) {

    private val frontLeft = ScMotor(hardwareMap, "frontLeft", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)
    private val frontRight = ScMotor(hardwareMap, "frontRight", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)
    private val backLeft = ScMotor(hardwareMap, "backLeft", DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)
    private val backRight = ScMotor(hardwareMap, "backRight", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)

    val setSpeed = {fun setSpeed(x: Double, y: Double, turn: Double) {
        val denominator = max(abs(y) + abs(x) + abs(turn), 1.0)
        frontLeft.effort = (y + x + turn) / denominator
        frontRight.effort = (y - x + turn) / denominator
        backLeft.effort = (y - x - turn) / denominator
        backRight.effort = (y + x - turn) / denominator

    }}

    val write = {fun write() {
        frontLeft.write()
        frontRight.write()
        backLeft.write()
        backRight.write()
    }}

    }
