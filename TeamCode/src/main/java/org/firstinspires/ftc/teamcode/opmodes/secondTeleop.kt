import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad




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
                flyWheel0.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
                flyWheel1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
                throngler.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE


                backRight.direction = DcMotorSimple.Direction.REVERSE
                backLeft.direction = DcMotorSimple.Direction.FORWARD
                frontRight.direction = DcMotorSimple.Direction.REVERSE
                frontLeft.direction = DcMotorSimple.Direction.FORWARD
                flyWheel0.direction = DcMotorSimple.Direction.FORWARD
                flyWheel1.direction = DcMotorSimple.Direction.FORWARD
                throngler.direction = DcMotorSimple.Direction.REVERSE



                waitForStart()



            waitForStart()

            while (opModeIsActive()) {

                previousGamepad1.copy(currentGamepad1)
                previousGamepad2.copy(currentGamepad2)

                currentGamepad1.copy(gamepad1)
                currentGamepad2.copy(gamepad2)

                val x = gamepad1.left_stick_x.toDouble() * 1.1 //
                val y = gamepad1.right_stick_x.toDouble() //y //rx
                val rx = gamepad1.left_stick_y.toDouble()  //rx //y
                val v = gamepad1.left_bumper
                val vv = previousGamepad1.left_bumper
                val t = gamepad1.right_bumper
                val tt = previousGamepad1.right_bumper
                val bl = gamepad1.right_trigger
                val br = gamepad1.left_trigger

                val leftTrigger = gamepad1.left_trigger
                val rightTrigger = gamepad1.right_trigger

                when {
                    rightTrigger > 0.1 -> throngler.power = 1.0
                    leftTrigger > 0.1  -> throngler.power = -1.0
                    else               -> throngler.power = 0.0
                }

                frontRight.power = y - x + rx
                frontLeft.power = y + x - rx
                backLeft.power = y - x - rx
                backRight.power = y + x + rx

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