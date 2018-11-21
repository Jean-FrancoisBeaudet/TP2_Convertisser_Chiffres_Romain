package ca.csf.pobj.tp2.RomanNumberConverter;

public class RomanNumberConverter {

    private RomanNumberConverter(){
        // private, this is a static class
    }

    public static String convert(int value) {
        assertPreCondition(value);

        StringBuilder romanNumber = new StringBuilder();
        int[] powers = getPowersFromValue(value);
        romanNumber.append(addLetters(powers[0], 'M'));
        romanNumber.append(convertPower(powers[1], 'C', 'D', 'M'));
        romanNumber.append(convertPower(powers[2], 'X', 'L', 'C'));
        romanNumber.append(convertPower(powers[3], 'I', 'V', 'X'));

        return romanNumber.toString();
    }

    private static int[] getPowersFromValue(int value) {
        String number = Integer.toString(value);
        int[] powers = new int[] {0,0,0,0};
        for (int i = 0; i < number.length() ; i++) {
            powers[3 - i] = Character.getNumericValue(number.charAt(number.length() - 1 - i));
        }
        return powers;
    }

    private static String convertPower(int value, char unit, char half, char nextPower){
        StringBuilder RomanPartialNumber = new StringBuilder();
        if(value >= 1 && value <= 3){
            RomanPartialNumber.append(addLetters(value, unit));
        }
        if(value == 4){
            RomanPartialNumber.append(unit);
            RomanPartialNumber.append(half);
        }
        if(value >= 5 && value <= 8){
            RomanPartialNumber.append(half);
            RomanPartialNumber.append(addLetters(value - 5, unit));
        }
        if(value == 9){
            RomanPartialNumber.append(unit);
            RomanPartialNumber.append(nextPower);
        }
        return RomanPartialNumber.toString();
    }

    private static String addLetters(int amount, char letter) {
        StringBuilder romanPartialNumber = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            romanPartialNumber.append(letter);
        }
        return romanPartialNumber.toString();
    }

    private static void assertPreCondition(int value) throws IllegalArgumentException {
        if (value <= 0 || value >= 5000) {
            throw new IllegalArgumentException("The number must be a positive integer between 1 and 4999 inclusive!");
        }
    }
}
