package org.firstinspires.ftc.teamcode.opmodes
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.util.ElapsedTime
import kotlin.math.abs
import kotlin.math.max

@Autonomous(name = "BackAuto", group = "Auto")
class BackTeleop: LinearOpMode() {
    override fun runOpMode() {
        val currentGamepad1 = Gamepad()
        val currentGamepad2 = Gamepad()
        val previousGamepad1 = Gamepad()
        val previousGamepad2 = Gamepad()

        val frontLeft = hardwareMap.get("frontLeft") as DcMotor
        val frontRight = hardwareMap.get("frontRight") as DcMotor
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor

        backRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        backLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        frontRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        frontLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

        backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

        backRight.direction = DcMotorSimple.Direction.FORWARD
        backLeft.direction = DcMotorSimple.Direction.REVERSE
        frontRight.direction = DcMotorSimple.Direction.REVERSE
        frontLeft.direction = DcMotorSimple.Direction.FORWARD

        val timer = ElapsedTime ()

        waitForStart()
        timer.reset()

        while (opModeIsActive() && timer.seconds() < 2.0) {

            backRight.power = -1.0
            backLeft.power = -0.8
            frontRight.power = -0.8
            frontLeft.power = -0.8

            telemetry.addData("Time", timer.seconds())
            telemetry.update()
        }

// Stop motors after time is up
        frontLeft.power = 0.0
        frontRight.power = 0.0
        backLeft.power = 0.0
        backRight.power = 0.0



        val y = -gamepad1.left_stick_y.toDouble() // Remember, Y stick value is reversed
            val x = gamepad1.left_stick_x.toDouble() * 1.1 // Counteract imperfect strafing
            val rx = gamepad1.right_stick_x.toDouble()

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            val denominator = max(abs(y) + abs(x) + abs(rx), 1.0)
            val frontLeftPower = (y + x + rx) / denominator
            val backLeftPower = (y - x + rx) / denominator
            val frontRightPower = (y - x - rx) / denominator
            val backRightPower = (y + x - rx) / denominator

            frontLeft.power = frontLeftPower
            frontRight.power = frontRightPower
            backRight.power = backRightPower
            backLeft.power = backLeftPower

        }}
