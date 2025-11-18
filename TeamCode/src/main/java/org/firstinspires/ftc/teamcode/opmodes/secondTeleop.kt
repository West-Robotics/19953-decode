import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import kotlin.math.abs
import kotlin.math.max




@TeleOp(name="(Not)ActualBotv1")
class SecondTeleop: LinearOpMode() {
        override fun runOpMode() {
            val currentGamepad1 = Gamepad()
            val currentGamepad2 = Gamepad()
            val previousGamepad1 = Gamepad()
            val previousGamepad2 = Gamepad()

            val frontLeft = hardwareMap.get("frontLeft") as DcMotor
            val frontRight = hardwareMap.get("frontRight") as DcMotor
            val backLeft = hardwareMap.get("backLeft") as DcMotor
            val backRight = hardwareMap.get("backRight") as DcMotor
            val flyWheel0 = hardwareMap.get("flyWheel0") as DcMotor
            val flyWheel1 = hardwareMap.get("flyWheel1") as DcMotor
            val throngler = hardwareMap.get("throngler") as DcMotor
            var togglethrongler = false
            var toggleflywheels = false

            backRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            backLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            frontRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            frontLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            flyWheel0.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            flyWheel1.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
            throngler.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

            backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
            backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
            frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
            frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
            flyWheel0.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
            flyWheel1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
            throngler.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

            backRight.direction = DcMotorSimple.Direction.FORWARD
            backLeft.direction = DcMotorSimple.Direction.REVERSE
            frontRight.direction = DcMotorSimple.Direction.REVERSE
            frontLeft.direction = DcMotorSimple.Direction.FORWARD
            flyWheel0.direction = DcMotorSimple.Direction.FORWARD
            flyWheel1.direction = DcMotorSimple.Direction.FORWARD
            throngler.direction = DcMotorSimple.Direction.REVERSE

            waitForStart()

            while (opModeIsActive()) {

                previousGamepad1.copy(currentGamepad1)
                previousGamepad2.copy(currentGamepad2)

                currentGamepad1.copy(gamepad1)
                currentGamepad2.copy(gamepad2)


                val y = -gamepad1.left_stick_y.toDouble() // Remember, Y stick value is reversed
                val x = gamepad1.left_stick_x * 1.1 // Counteract imperfect strafing
                val rx = gamepad1.right_stick_x.toDouble()


                // Denominator is the largest motor power (absolute value) or 1
                // This ensures all the powers maintain the same ratio,
                // but only if at least one is out of the range [-1, 1]
                val denominator = max(abs(y) + abs(x) + abs(rx), 1.0)
                val frontLeftPower = (y + x + rx) / denominator
                val backLeftPower = (y - x + rx) / denominator
                val frontRightPower = (y - x - rx) / denominator
                val backRightPower = (y + x - rx) / denominator


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

                frontLeft.power = frontLeftPower
                frontRight.power = frontRightPower
                backRight.power = backRightPower
                backLeft.power = backLeftPower

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