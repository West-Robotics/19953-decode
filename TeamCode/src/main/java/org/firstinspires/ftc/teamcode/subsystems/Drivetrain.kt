package org.firstinspires.ftc.teamcode.subsystems
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
//import com.qualcomm.robotcore.hardware.external.Telemetry
//import com.qualcomm.robotcore.hardware.robertMkII.hardware.NgMotor
import java.util.Locale



class Drivetrain(hardwareMap: HardwareMap) {

    private val frontLeft =
    private val frontRight = (DcMotor)(hardwareMap.get("frontRight") as DcMotor, DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER)
    private val backLeft = (DcMotor)(hardwareMap.get("backLeft") as DcMotor, DcMotorSimple.Direction.REVERSE, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER)
    private val backRight = (DcMotor)(hardwareMap.get("backRight") as DcMotor, DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE, DcMotor.RunMode.RUN_WITHOUT_ENCODER)

    fun setSpeed(x: Double, y:Double, turn: Double) {
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
