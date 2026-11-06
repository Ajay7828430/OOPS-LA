package calculator;

public class InputValidator {

    // Check whether input is empty
    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    // Check whether input is a valid number
    public static boolean isValidNumber(String input) {

        if (isEmpty(input)) {
            return false;
        }

        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
