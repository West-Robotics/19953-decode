package org.firstinspires.ftc.teamcode.subsystems

//import com.qualcomm.robotcore.hardware.external.Telemetry
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import kotlin.math.abs
import kotlin.math.max

class Flywheel (hardwareMap: HardwareMap){
    private val leftFlywheel = ScMotor(hardwareMap, "flywheel0", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)

    private val rightFlywheel = ScMotor(hardwareMap, "flywheel1", DcMotorSimple.Direction.FORWARD, DcMotor.ZeroPowerBehavior.BRAKE)

}