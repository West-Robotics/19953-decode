import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain
import kotlin.math.abs
import kotlin.math.max


@TeleOp(name="thelastonefr")
class SecondTeleop: LinearOpMode() {
        override fun runOpMode() {
            val currentGamepad1 = Gamepad()
            val currentGamepad2 = Gamepad()
            val previousGamepad1 = Gamepad()
            val previousGamepad2 = Gamepad()
            val driveTrain = Drivetrain()

            val flyWheel0 = hardwareMap.get("flyWheel0") as DcMotor
            val flyWheel1 = hardwareMap.get("flyWheel1") as DcMotor
            val throngler = hardwareMap.get("throngler") as DcMotor
            var togglethrongler = false
            var toggleflywheels = false


            flyWheel0.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            flyWheel1.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            throngler.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

            flyWheel0.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
            flyWheel1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
            throngler.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

            flyWheel0.direction = DcMotorSimple.Direction.FORWARD
            flyWheel1.direction = DcMotorSimple.Direction.FORWARD
            throngler.direction = DcMotorSimple.Direction.REVERSE

            waitForStart()

            while (opModeIsActive()) {

                previousGamepad1.copy(currentGamepad1)
                previousGamepad2.copy(currentGamepad2)

                currentGamepad1.copy(gamepad1)
                currentGamepad2.copy(gamepad2)

                driveTrain.write
                driveTrain.setSpeed

                val y = -gamepad1.left_stick_y.toDouble() // Remember, Y stick value is reversed
                val x = gamepad1.left_stick_x * 1.1 // Counteract imperfect strafing
                val rx = gamepad1.right_stick_x.toDouble()

                val v = gamepad1.left_bumper
                val vv = previousGamepad1.left_bumper
                val t = gamepad1.right_bumper
                val tt = previousGamepad1.right_bumper
                val bl = gamepad1.right_trigger
                val br = gamepad1.left_trigger

                val leftTrigger = gamepad1.left_trigger
                val rightTrigger = gamepad1.right_trigger

                when {
                    leftTrigger > 0.1 -> throngler.power = .3
                    rightTrigger > 0.1  -> throngler.power = -.3
                    else               -> throngler.power = 0.0
                }


                if (v && !vv) {
                    toggleflywheels = !toggleflywheels
                }

                if (toggleflywheels) {
                    flyWheel0.power = 1.0
                    flyWheel1.power = -1.0
                } else {
                    flyWheel0.power = 0.0
                    flyWheel1.power = 0.0
                }
            }}}