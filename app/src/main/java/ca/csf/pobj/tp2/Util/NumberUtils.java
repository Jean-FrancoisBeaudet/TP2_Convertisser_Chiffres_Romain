package ca.csf.pobj.tp2.Util;

public final class NumberUtils {

    private NumberUtils(){
        // private, this is a static class
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean isInputInt(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

}