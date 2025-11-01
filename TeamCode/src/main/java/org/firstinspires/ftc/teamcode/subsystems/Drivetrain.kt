package org.firstinspires.ftc.teamcode.subsystems
//import com.qualcomm.robotcore.hardware.external.Telemetry
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap


class Drivetrain(hardwareMap: HardwareMap) {

    private val frontLeft = ScMotor(hardwareMap, ("frontLeft"), DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)
    private val frontRight = ScMotor(hardwareMap, ("frontRight"), DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)
    private val backLeft = ScMotor(hardwareMap, ("backLeft"), DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE)
    private val backRight = ScMotor(hardwareMap, ("backRight"), DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)

    fun setSpeed(x: Double, y: Double, turn: Double) {
        frontLeft.effort = y - x + turn
        frontRight.effort = y + x - turn
        backLeft.effort = y + x + turn
        backRight.effort = y - x - turn

    }

    fun write() {
        frontLeft.write()
        frontRight.write()
        backLeft.write()
        backRight.write()
    }

    }
