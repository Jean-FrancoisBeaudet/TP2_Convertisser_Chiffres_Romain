package ca.csf.pobj.tp2.Util;

public final class StringUtils {

    private StringUtils(){
        // private, this is a static class
    }

    public static boolean isBlank(String string) {
        for (int i = 0; i < string.length(); i++) {
            if(!Character.isWhitespace(string.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
