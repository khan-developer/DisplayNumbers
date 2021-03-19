import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class DisplayNumbersMain {

    private static final Logger logger = LoggerFactory.getLogger(DisplayNumbers.class);

    public static void main(String[] args){
        System.out.println("Please enter any number: ");
        Scanner in = new Scanner(System.in);

        final String providedStrNumber = in.nextLine();
        System.out.println("You entered number " + providedStrNumber);

        LcdScreen lcdScreen = new LcdScreen();
        lcdScreen.display(providedStrNumber);
    }
}
