import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple


@TeleOp(name="ActualBot")
class SecondTeleop: LinearOpMode() {


        override fun runOpMode() {
                /*val frontLeft = hardwareMap.get("frontLeft") as DcMotor
                val frontRight = hardwareMap.get("frontRight") as DcMotor
                val backLeft = hardwareMap.get("backLeft") as DcMotor
                val backRight = hardwareMap.get("backRight") as DcMotor*/
                val flyWheel0 = hardwareMap.get("flyWheel0") as DcMotor
                val flyWheel1 = hardwareMap.get("flyWheel1") as DcMotor
                val throngler = hardwareMap.get("throngler") as DcMotor
                var togglethrongler = false
                var toggleflywheel = false

                /*backRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
                backLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
                frontRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
                frontLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER*/
                flyWheel0.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
                flyWheel1.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
                throngler.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

                /*backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
                backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
                frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
                frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE*/
                flyWheel0.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
                flyWheel1.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
                throngler.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT


                /*backRight.direction = DcMotorSimple.Direction.FORWARD
                backLeft.direction = DcMotorSimple.Direction.REVERSE
                frontRight.direction = DcMotorSimple.Direction.REVERSE
                frontLeft.direction = DcMotorSimple.Direction.FORWARD*/
                flyWheel0.direction = DcMotorSimple.Direction.FORWARD
                flyWheel1.direction = DcMotorSimple.Direction.REVERSE
                throngler.direction = DcMotorSimple.Direction.FORWARD



                waitForStart()



                while (opModeIsActive()) {


                    /*val x = gamepad1.left_stick_x.toDouble() * 1.1
                    val rx = gamepad1.right_stick_x.toDouble()
                    val y = -gamepad1.left_stick_y.toDouble()*/
                    val v = gamepad1.left_bumper
                    val t = gamepad1.right_bumper


                    if (t && !t) {

                        togglethrongler = !togglethrongler
                    }

                    if (v && !v) {

                        toggleflywheel = !toggleflywheel
                    }


                    /*frontRight.power =  y - x + rx
                    frontLeft.power =  y + x - rx
                    backLeft.power =  y - x - rx
                    backRight.power =  y + x + rx*/


                    if (toggleflywheel) {
                        flyWheel0.power = 1.toDouble()
                        flyWheel1.power = (-1).toDouble()
                    }
                    else {
                        flyWheel0.power = 0.toDouble()
                        flyWheel1.power = 0.toDouble()
                    }


                    if (togglethrongler) {
                        throngler.power = 0.5
                    }
                    else {
                        throngler.power = 0.toDouble()
                    }






                }
            }
        }
