import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LcdScreenTest {

    @Test
    public void assertThatIfValidNumberProvidedItReturnsTrue(){
        LcdScreen lcdScreen = new LcdScreen();
        assertTrue(lcdScreen.validateInputNumber("124"));
        assertTrue(lcdScreen.validateInputNumber("1 2"));
        assertTrue(lcdScreen.validateInputNumber("0 0"));
    }

    @Test
    public void assertThatIfInValidNumberProvidedItReturnsFalse(){
        LcdScreen lcdScreen = new LcdScreen();
        assertFalse(lcdScreen.validateInputNumber("ABC"));
        assertFalse(lcdScreen.validateInputNumber("12A"));
        assertFalse(lcdScreen.validateInputNumber("10-"));
        assertFalse(lcdScreen.validateInputNumber("0O0")); //with O in between zero
        assertFalse(lcdScreen.validateInputNumber("0 O"));
    }
}
