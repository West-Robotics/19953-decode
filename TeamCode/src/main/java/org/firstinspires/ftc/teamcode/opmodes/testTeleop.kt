package org.firstinspires.ftc.teamcode.opmodes

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain


@TeleOp(name="TestBotTime")
class TestTeleop: LinearOpMode() {


    override fun runOpMode() {

        val currentGamepad1 = Gamepad()
        val currentGamepad2 = Gamepad()

        val previousGamepad1 = Gamepad()
        val previousGamepad2 = Gamepad()

        val frontLeft = (Drivetrain(hardwareMap,"frontLeft"))
        val frontRight = (Drivetrain())
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor
        val flyWheel0 = hardwareMap.get("flyWheel0") as DcMotor
        val flyWheel1 = hardwareMap.get("flyWheel1") as DcMotor
        val throngler = hardwareMap.get("throngler") as DcMotor
        var togglethrongler = false
        var toggleflywheels = false


        backRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        backLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        flyWheel0.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        flyWheel1.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        throngler.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

        backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        flyWheel0.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        flyWheel1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        throngler.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT


        backRight.direction = DcMotorSimple.Direction.REVERSE
        backLeft.direction = DcMotorSimple.Direction.FORWARD
        flyWheel0.direction = DcMotorSimple.Direction.FORWARD
        flyWheel1.direction = DcMotorSimple.Direction.FORWARD
        throngler.direction = DcMotorSimple.Direction.REVERSE

        waitForStart()

        while (opModeIsActive()) {

            previousGamepad1.copy(currentGamepad1)
            previousGamepad2.copy(currentGamepad2)

            currentGamepad1.copy(gamepad1)
            currentGamepad2.copy(gamepad2)





            while(opModeIsActive()){
                backLeft.power =  -gamepad1.left_stick_y.toDouble() - gamepad1.left_stick_x.toDouble() * 1.1 - gamepad1.right_stick_x.toDouble()
                backRight.power =  -gamepad1.left_stick_y.toDouble() + gamepad1.left_stick_x.toDouble() * 1.1 + gamepad1.right_stick_x.toDouble()


                if (gamepad1.right_bumper && !previousGamepad1.right_bumper) {

                    togglethrongler = !togglethrongler
                }

                if (gamepad1.left_bumper && !previousGamepad1.left_bumper) {

                    toggleflywheels = !toggleflywheels
                }


                if (toggleflywheels) {
                    flyWheel0.power = 1.0
                    flyWheel1.power = -1.0
                }
                else {
                    flyWheel0.power = 0.0
                    flyWheel1.power = 0.0
                }


                if (togglethrongler) {
                    throngler.power = 1.0
                }
                else {
                    throngler.power = 0.0
                }



            }


        }
    }


}
