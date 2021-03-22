package com.technicaltest.lcdscreen;

import com.technicaltest.exceptions.InputValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LcdDisplayImpl implements LcdDisplay {

    private final Logger LOGGER = LoggerFactory.getLogger(LcdDisplayImpl.class);
    private static final String REMOVE_SPACE_REGEX = "\\s+";
    private static final String REPLACEMENT_STRING = "";

    /**
     * Method to validate and display number on screen
     *
     * @param strNumber : user provided string number
     */
    @Override
    public void displayNumber(String strNumber) {

        strNumber = strNumber.replaceAll(
                REMOVE_SPACE_REGEX, REPLACEMENT_STRING);

        if (validateInputNumber(strNumber)) {
            LOGGER.info("Input value " + strNumber + " is a valid number");
            displayNumberOnScreen(strNumber);
        } else {
            LOGGER.error("The input value provided is not a valid number");
            throw new InputValidationException("The input value provided is not a valid number");
        }
    }

    /**
     * Method responsible to display provided numbers on screen
     *
     * @param strNumber : user provided string number
     */
    private void displayNumberOnScreen(String strNumber) {
        int numberOfChars = strNumber.length();
        int[][][] numCharsArray = getNumCharsArray(numberOfChars, strNumber);
        LOGGER.info("About to display numbers on screen");
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

    /**
     * Method to get number chars array for the string number
     *
     * @param numberOfChars : length of the string number provided
     * @param strNumber     : user provided string number
     */
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

    /**
     * Method to validate the input number provided, if it's valid integer
     *
     * @param strNumber : user provided string number
     */
    public boolean validateInputNumber(String strNumber) {
        if (strNumber == null) {
            LOGGER.error("The input value provided is null");
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
