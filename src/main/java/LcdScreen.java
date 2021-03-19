import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LcdScreen implements DisplayNumbers {

    private static final String REMOVE_SPACE_REGEX = "\\s+";
    private static final String REPLACEMENT_STRING = "";

    @Override
    public void display(String strNumber) {

        strNumber = strNumber.replaceAll(
                REMOVE_SPACE_REGEX, REPLACEMENT_STRING);

        if (validateInputNumber(strNumber)) {

            log.info("Input value " + strNumber + " is a valid number, going to display on screen");
            displayNumberOnScreen(strNumber);
        } else {

            log.error("The input value provided is not a valid number");
            throw new InputValidationException("The input value provided is not a valid number");
        }
    }

    private void displayNumberOnScreen(String strNumber) {
        int numberOfChars = strNumber.length();
        int[][][] numCharsArray = getNumCharsArray(numberOfChars, strNumber);

        int i, j, k;
        for (j = 0; j < 3; j++) {
            for (i = 0; i < numberOfChars; i++) {
                for (k = 0; k < 3; k++) {
                    if (numCharsArray[i][j][k] == 1) {
                        if (k == 1) System.out.print("_");
                        else System.out.print("|");
                    } else System.out.print(".");
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public int[][][] getNumCharsArray(int numberOfChars, String strNumber) {
        final int[][] one = {{0, 0, 0}, {0, 0, 1}, {0, 0, 1}};
        final int[][] two = {{0, 1, 0}, {0, 1, 1}, {1, 1, 0}};
        final int[][] three = {{0, 1, 0}, {0, 1, 1}, {0, 1, 1}};
        final int[][] four = {{0, 0, 0}, {1, 1, 1}, {0, 0, 1}};
        final int[][] five = {{0, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        final int[][] six = {{0, 1, 0}, {1, 1, 0}, {1, 1, 1}};
        final int[][] seven = {{0, 1, 0}, {0, 0, 1}, {0, 0, 1}};
        final int[][] eight = {{0, 1, 0}, {1, 1, 1}, {1, 1, 1}};
        final int[][] nine = {{0, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        final int[][] zero = {{0, 1, 0}, {1, 0, 1}, {1, 1, 1}};

        int[][][] chars = new int[numberOfChars][3][3];

        for (int i = 0; i < numberOfChars; i++) {

            if (strNumber.charAt(i) == '1') chars[i] = one;
            else if (strNumber.charAt(i) == '2') chars[i] = two;
            else if (strNumber.charAt(i) == '3') chars[i] = three;
            else if (strNumber.charAt(i) == '4') chars[i] = four;
            else if (strNumber.charAt(i) == '5') chars[i] = five;
            else if (strNumber.charAt(i) == '6') chars[i] = six;
            else if (strNumber.charAt(i) == '7') chars[i] = seven;
            else if (strNumber.charAt(i) == '8') chars[i] = eight;
            else if (strNumber.charAt(i) == '9') chars[i] = nine;
            else if (strNumber.charAt(i) == '0') chars[i] = zero;
        }
        return chars;
    }

    public boolean validateInputNumber(String strNumber) {
        if (strNumber == null) {
            return false;
        }
        try {
            Integer.parseInt(strNumber);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
