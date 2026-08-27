package org.firstinspires.ftc.teamcode.learning

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.CRServo
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo

@TeleOp(name = "MEEE")
class Raziel: LinearOpMode(){

    override fun runOpMode() {

        val razielclass = `Dependency-raziel`(hardwareMap)



        val motor1 = hardwareMap.get("name") as DcMotorEx
        val motor2 = hardwareMap.get("othername") as DcMotorEx


        motor1.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        motor1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        motor1.direction = DcMotorSimple.Direction.FORWARD

        motor2.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        motor2.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        motor2.direction = DcMotorSimple.Direction.REVERSE

        var toggle = false

        waitForStart()

        while (opModeIsActive()){
            // INT 10 12 14
            // FLOAT 10.0001
            // DOUBLE 10.000000001  14.0
            // BOOLEAN true false
            // STRING "hi" "hello world"


            val joystick = gamepad1.left_stick_x

            motor2.power = joystick.toDouble()

            if (gamepad1.xWasPressed()){
                toggle = !toggle
            }

            if(toggle){
                razielclass.runMotor()
            } else {
                razielclass.stopMotor()
            }






        }


    }
}