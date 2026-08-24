package org.firstinspires.ftc.teamcode.opmodes

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain
 
@TeleOp(name="drivetrain")
class drivetrain: LinearOpMode() {
    override fun runOpMode() {
        val currentGamepad1 = Gamepad()
        val currentGamepad2 = Gamepad()
        val previousGamepad1 = Gamepad()
        val previousGamepad2 = Gamepad()
        val driveTrain = Drivetrain(hardwareMap)

        waitForStart()

        while (opModeIsActive()) {

            previousGamepad1.copy(currentGamepad1)
            previousGamepad2.copy(currentGamepad2)

            currentGamepad1.copy(gamepad1)
            currentGamepad2.copy(gamepad2)

            // Drive: left stick = strafe/forward, right stick x = turn
            val x = gamepad1.left_stick_x.toDouble()
            val y = -gamepad1.left_stick_y.toDouble() // stick is inverted (up = negative)
            val turn = gamepad1.right_stick_x.toDouble()

            driveTrain.setSpeed(x, y, turn)
            driveTrain.write()

            val t = gamepad1.right_bumper
            val tt = previousGamepad1.right_bumper
            val bl = gamepad1.right_trigger
            val br = gamepad1.left_trigger

        }
    }
}