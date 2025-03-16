package umbrella.com.lilyprofect.utils;

import umbrella.com.lilyproject.cnc.graphics.cnc.LilyCncController;

public class CncUtils {

    public static final int X_STEPS = 3;
    public static final int X_SPEED = 450;

    public static final int Y_STEPS = 3;
    public static final int Y_SPEED = 500;

    public static final int Z_STEPS = 10;
    public static final int Z_SPEED = 200;

    public static final int DELAY_TIME = 50;

    public static String goNorth(int steps){
        return "y" + "," + "constantMovementForward" + "," + steps * Y_STEPS + "," + X_SPEED;
    }

    public static String goSouth(int steps){
        return "y" + "," + "constantMovementBackward" + "," + steps * Y_STEPS + "," + X_SPEED;
    }

    public static String goEast(int steps){
        return "x" + "," + "constantMovementForward" + "," + steps * X_STEPS + "," + Y_SPEED;
    }

    public static String goWest(int steps){
        return "x" + "," + "constantMovementBackward" + "," + steps * X_STEPS + "," + Y_SPEED;
    }

    public static String goUp(int steps){
        return "z" + "," + "constantMovementForward" + "," + steps * Z_STEPS + "," + Z_SPEED;
    }

    public static String goDown(int steps){
        return "z" + "," + "constantMovementBackward" + "," + steps *Z_STEPS + "," + Z_SPEED;
    }



    public static String goNorth(){
        return "x" + "," + "constantMovementForward" + "," + X_STEPS + "," + X_SPEED;
    }

    public static String goSouth(){
        return "x" + "," + "constantMovementBackward" + "," + X_STEPS + "," + X_SPEED;
    }

    public static String goEast(){
        return "y" + "," + "constantMovementForward" + "," + Y_STEPS + "," + Y_SPEED;
    }

    public static String goWest(){
        return "y" + "," + "constantMovementBackward" + "," + Y_STEPS + "," + Y_SPEED;
    }

    public static String goUp(){
        return "z" + "," + "constantMovementForward" + "," + Z_STEPS + "," + Z_SPEED;
    }

    public static String goDown(){
        return "z" + "," + "constantMovementBackward" + "," + Z_STEPS + "," + Z_SPEED;
    }
}
