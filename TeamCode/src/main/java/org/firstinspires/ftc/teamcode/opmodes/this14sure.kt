package org.firstinspires.ftc.teamcode.opmodes
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.CRServo
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain
@TeleOp(name="this14sure")
class this14sure: LinearOpMode() {
    override fun runOpMode() {
        val currentGamepad1 = Gamepad() //used to check if a button was pressed
        val currentGamepad2 = Gamepad()
        val previousGamepad1 = Gamepad()
        val previousGamepad2 = Gamepad()
        val driveTrain = Drivetrain(hardwareMap) //pulls drivetrain subsystem
        val intake = hardwareMap.get("intake") as DcMotor
        val flywheel1 = hardwareMap.get("flywheel1") as DcMotor
        val flywheel2 = hardwareMap.get("flywheel2") as DcMotor
        val servo2 = hardwareMap.get("servo2") as CRServo
        var servo2toggle = false
        val servo1 = hardwareMap.get("servo1") as Servo
        var servo1toggle = false
        intake.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        intake.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        intake.direction = DcMotorSimple.Direction.FORWARD
        flywheel1.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        flywheel1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        flywheel1.direction = DcMotorSimple.Direction.REVERSE
        flywheel2.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        flywheel2.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        flywheel2.direction = DcMotorSimple.Direction.FORWARD
        waitForStart()
        while (opModeIsActive()) {
            previousGamepad1.copy(currentGamepad1) //used to check if a button was pressed
            previousGamepad2.copy(currentGamepad2)
            currentGamepad1.copy(gamepad1)
            currentGamepad2.copy(gamepad2)
            // Drive: left stick = strafe/forward, right stick x = turn
            val x = gamepad1.left_stick_x.toDouble() // driving controls
            val y = -gamepad1.left_stick_y.toDouble() * 1.1 // *1.1 counteracts imperfect strafing stick is inverted (up = negative)
            val turn = gamepad1.right_stick_x.toDouble()
            driveTrain.setSpeed(x, y, turn)
            driveTrain.write()


            if(currentGamepad1.right_bumper){
                intake.power = 1.0
            } else {
                intake.power = 0.0
            }


            if(currentGamepad1.left_bumper){
                flywheel1.power = 1.0
                flywheel2.power = 1.0
            }else{
                flywheel1.power = 0.0
                flywheel2.power = 0.0
            }


            if(currentGamepad1.a && previousGamepad1.a){
                servo2toggle = !servo2toggle
            }
            if (servo2toggle == true) {
                servo2.power = 1.0
            }else{
                servo2.power = 0.0
            }
            servo1.position = .6
            if(currentGamepad1.b && previousGamepad1.b){
                servo1toggle = !servo1toggle
            }
            if (servo1toggle == true) {
                servo1.position = 0.7
            }else {
                servo1.position = 0.6
            }
        }
    }
}

