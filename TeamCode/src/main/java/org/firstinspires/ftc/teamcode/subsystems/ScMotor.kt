package org.firstinspires.ftc.teamcode.subsystems


import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit
import kotlin.math.abs


class ScMotor(
    hardwareMap: HardwareMap,
    name: String,
    dir: Direction,
    zpb: ZeroPowerBehavior,
    val eps: Double = 0.005
) {
    private val motor = hardwareMap.dcMotor.get(name) as DcMotorEx
    private var _effort = 0.0
    private var lasteffort = 9999.0

    var effort
    get () = _effort
    set(value) = if(abs(value - _effort) > eps) {
        _effort = value
    } else Unit

    fun write() {
        if (abs(lasteffort - effort) > eps) {
            motor.power = effort
            lasteffort = effort
        }
        }
    val current: Double
        get() = motor.getCurrent(CurrentUnit.AMPS)

    init {
        motor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        motor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        motor.direction = dir
        motor.zeroPowerBehavior = zpb
    }

    }
