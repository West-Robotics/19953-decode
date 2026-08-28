package org.firstinspires.ftc.teamcode.learning
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotor

@TeleOp
class Nick: LinearOpMode() {
    override fun runOpMode() {

        val motor1 = hardwareMap.get("motor1") as DcMotorEx
        val motor2 = hardwareMap.get("motor2") as DcMotorEx


        motor1.power = -1.0
        motor1.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        motor1.direction = DcMotorSimple.Direction.FORWARD
        motor2.power = -1.0
        motor2.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        motor2.direction = DcMotorSimple.Direction.FORWARD




        waitForStart()
        while (opModeIsActive()){

            val joystick = gamepad1.left_stick_x

            motor2.power = joystick.toDouble()

            if (gamepad1.x){
                motor1.power = 1.0
                motor2.power = 1.0
            } else {
                motor1.power= 0.0
                motor2.power=0.0
            }



        }
    }

}