package co.edu.escuelaing.sparkdockerdemolive;

import java.util.Objects;

public class MyAppService {

    /**
     * Calculates the cosine of a number.
     *
     * @param number the number in radians
     * @return the cosine of the number
     * @throws IllegalArgumentException if the number is not a valid double
     */
    public static String getCos(String number) {
        validateNumber(number);
        double numberX = Math.cos(Double.parseDouble(number));
        return String.valueOf(numberX);
    }

    /**
     * Calculates the sine of a number.
     *
     * @param number the number in radians
     * @return the sine of the number
     * @throws IllegalArgumentException if the number is not a valid double
     */
    public static String getSin(String number) {
        validateNumber(number);
        double numberX = Math.sin(Double.parseDouble(number));
        return String.valueOf(numberX);
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the word to check
     * @return "Its Palindrome" if the word is a palindrome, otherwise "It is not a Palindrome"
     */
    public static String isPalindrome(String word) {
        word = word.toLowerCase();
        String reversedWord = new StringBuilder(word).reverse().toString();
        boolean flag = word.equals(reversedWord);
        String ans = flag ? "Its Palindrome" : "It is not a Palindrome";
        return ans;
    }

    /**
     * Calculates the magnitude of two numbers.
     *
     * @param str1 the first number
     * @param str2 the second number
     * @return the magnitude of the two numbers
     * @throws IllegalArgumentException if either number is not a valid double
     */
    public static String getMagnitude(String str1, String str2) {
        validateNumber(str1);
        validateNumber(str2);
        double number1 = Math.pow(2, Double.parseDouble(str1));
        double number2 = Math.pow(2, Double.parseDouble(str2));
        double magnitude = Math.sqrt(number1 + number2);
        return String.valueOf(magnitude);
    }

    /**
     * Validates that a string can be parsed to a double.
     *
     * @param number the number to validate
     * @throws IllegalArgumentException if the number is not a valid double
     */
    private static void validateNumber(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + number);
        }
    }
}
