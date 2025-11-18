package org.firstinspires.ftc.teamcode.opmodes

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple

@TeleOp(name="Test")
class Test : LinearOpMode(){
    override fun runOpMode() {
        val frontLeft = hardwareMap.get("frontLeft") as DcMotor
        val frontRight = hardwareMap.get("frontRight") as DcMotor
        val backLeft = hardwareMap.get("backLeft") as DcMotor
        val backRight = hardwareMap.get("backRight") as DcMotor

        backRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        backLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        frontRight.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        frontLeft.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

        backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE


        backRight.direction = DcMotorSimple.Direction.FORWARD
        backLeft.direction = DcMotorSimple.Direction.REVERSE
        frontRight.direction = DcMotorSimple.Direction.REVERSE
        frontLeft.direction = DcMotorSimple.Direction.FORWARD

        waitForStart()
        while (opModeIsActive()){
            if (gamepad1.a){
                frontLeft.power = 1.0
            } else  {
                frontLeft.power = 0.0
            }
            if (gamepad1.b){
                frontRight.power = 1.0
            } else  {
                frontRight.power = 0.0
            }
            if (gamepad1.x){
                backLeft.power = 1.0
            } else  {
                backLeft.power = 0.0
            }
            if (gamepad1.y){
                backRight.power = 1.0
            } else  {
                backRight.power = 0.0
            }
        }
    }
}