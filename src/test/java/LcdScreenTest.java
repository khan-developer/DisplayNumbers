import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LcdScreenTest {

    private LcdScreen lcdScreen;

    @Before
    public void init() {
        lcdScreen = new LcdScreen();
    }

    @Test
    public void assertThatIfValidNumberProvided_ItReturnsTrue() {
        assertTrue(lcdScreen.validateInputNumber("124"));
        assertTrue(lcdScreen.validateInputNumber("111"));
        assertTrue(lcdScreen.validateInputNumber("000"));
    }

    @Test
    public void assertThatIfInValidNumberProvided_ItReturnsFalse() {
        assertFalse(lcdScreen.validateInputNumber("ABC"));
        assertFalse(lcdScreen.validateInputNumber("12A"));
        assertFalse(lcdScreen.validateInputNumber("10-"));
        assertFalse(lcdScreen.validateInputNumber("0O0")); //with O in between zero
        assertFalse(lcdScreen.validateInputNumber("0/O"));
    }

    @Test
    public void returnsValidNumberArray() {
        String strNumber = "22";
        int noOfChars = strNumber.length();
        final int[][] two = {{0, 1, 0}, {0, 1, 1}, {1, 1, 0}};
        int[][][] chars = new int[2][3][3];

        for (int i = 0; i < 2; i++) {
            chars[i] = two;
        }

        int[][][] numCharsArray = lcdScreen.getNumCharsArray(noOfChars, strNumber);

        assertArrayEquals(numCharsArray, chars);
    }

    @Test(expected = InputValidationException.class)
    public void whenInvalidNumberProvided_ThenExceptionIsThrown() {
        lcdScreen.display("1O");
    }

    @Test()
    public void whenValidNumberProvidedWithExtraSpaces_ThenNoExceptionIsThrown() {
        lcdScreen.display("1 9");
    }

}
