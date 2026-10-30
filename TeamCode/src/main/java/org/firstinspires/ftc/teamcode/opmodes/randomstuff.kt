package org.firstinspires.ftc.teamcode.opmodes
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain
@TeleOp(name="randomstuff")
class randomstuff: LinearOpMode() {
    override fun runOpMode() {
        val currentGamepad1 = Gamepad() //used to check if a button was pressed
        val currentGamepad2 = Gamepad()
        val previousGamepad1 = Gamepad()
        val previousGamepad2 = Gamepad()
        val servo = hardwareMap.get("servo") as Servo
        servo.position = 0.5
        val motor = hardwareMap.get("motor") as DcMotor
        motor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        motor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        motor.direction = DcMotorSimple.Direction.REVERSE
        waitForStart()
        while (opModeIsActive()) {
            previousGamepad1.copy(currentGamepad1) //used to check if a button was pressed
            previousGamepad2.copy(currentGamepad2)
            currentGamepad1.copy(gamepad1)
            currentGamepad2.copy(gamepad2)
            if(currentGamepad1.right_bumper){
                motor.power = 1.0
            } else {
                motor.power = 0.0
            }

            if(currentGamepad1.a) {
                servo.position = 0.0
            }else{
                servo.position = 0.5
            }
            if(currentGamepad1.b) {
                servo.position = 1.0
            }else{
                servo.position = 0.5
            }

        }
    }
}