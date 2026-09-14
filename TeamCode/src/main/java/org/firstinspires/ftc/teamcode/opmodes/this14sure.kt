package org.firstinspires.ftc.teamcode.opmodes
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain


@TeleOp(name="this14sure")
class this14sure: LinearOpMode() {
    override fun runOpMode() {
//        val currentGamepad1 = Gamepad()
//        val currentGamepad2 = Gamepad()
//        val previousGamepad1 = Gamepad()
//        val previousGamepad2 = Gamepad()
        val driveTrain = Drivetrain(hardwareMap)
        val servo1 = hardwareMap.get("servo1") as Servo
        val servo2 = hardwareMap.get("servo2") as Servo
        val servo3 = hardwareMap.get("servo3") as Servo

        servo1.position = .5
        servo2.position = .5
        servo3.position = .5


        waitForStart()


        while (opModeIsActive()) {


//            previousGamepad1.copy(currentGamepad1)
//            previousGamepad2.copy(currentGamepad2)
//
//            currentGamepad1.copy(gamepad1)
//            currentGamepad2.copy(gamepad2)


            // Drive: left stick = strafe/forward, right stick x = turn
            val x = gamepad1.left_stick_x.toDouble()
            val y = -gamepad1.left_stick_y.toDouble() * 1.1 // *1.1 counteracts imperfect strafing stick is inverted (up = negative)
            val turn = gamepad1.right_stick_x.toDouble()
            driveTrain.setSpeed(x, y, turn)
            driveTrain.write()


            if (gamepad1.a){
                servo2.position = 1.0
            }

            if (gamepad1.b){
                servo2.position = 0.0
            }

            if (gamepad1.x){
                servo3.position = 1.0
            }
            
            if (gamepad1.y)  {
                servo3.position = 0.0
            }


//            if (gamepad1.a) {
//                servo1.position += 0.001
//            }
//
//            if (gamepad1.b) {
//                servo1.position -= 0.001
//            }
        }
    }
}

