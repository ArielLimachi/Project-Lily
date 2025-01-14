package umbrella.com.lilyprofect.utils;

public class ArduinoUtils {

    public static final String PORT_NAME = "COM3";

    public static String getAsString(String command, int steps, int velocity) {
        return command + Constants.SPACE + steps + Constants.SPACE + velocity;
    }

    public static String getAsString(String command, int acceleration) {
        return command + Constants.SPACE + acceleration;
    }

    public static String getAsString(String command) {
        return command;
    }
}
