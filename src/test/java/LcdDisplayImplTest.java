import com.technicaltest.exceptions.InputValidationException;
import com.technicaltest.lcdscreen.LcdDisplayImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LcdDisplayImplTest {

    private LcdDisplayImpl displayNumbersImpl;

    @Before
    public void init() {
        displayNumbersImpl = new LcdDisplayImpl();
    }

    @Test
    public void assertThatIfValidNumberProvided_ItReturnsTrue() {
        assertTrue(displayNumbersImpl.validateInputNumber("124"));
        assertTrue(displayNumbersImpl.validateInputNumber("111"));
        assertTrue(displayNumbersImpl.validateInputNumber("000"));
    }

    @Test
    public void assertThatIfInValidNumberProvided_ItReturnsFalse() {
        assertFalse(displayNumbersImpl.validateInputNumber("ABC"));
        assertFalse(displayNumbersImpl.validateInputNumber("12A"));
        assertFalse(displayNumbersImpl.validateInputNumber("10-"));
        assertFalse(displayNumbersImpl.validateInputNumber("0O0")); //with O in between zero
        assertFalse(displayNumbersImpl.validateInputNumber("0/O"));
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

        int[][][] numCharsArray = displayNumbersImpl.getNumCharsArray(noOfChars, strNumber);

        assertArrayEquals(numCharsArray, chars);
    }

    @Test(expected = InputValidationException.class)
    public void whenInvalidNumberProvided_ThenExceptionIsThrown() {
        displayNumbersImpl.displayNumber("1O");
    }

    @Test()
    public void whenValidNumberProvidedWithExtraSpaces_ThenNoExceptionIsThrown() {
        displayNumbersImpl.displayNumber("1 9");
    }

}
