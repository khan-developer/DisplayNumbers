
import java.util.Scanner;

public class DisplayNumbersMain {


    public static void main(String[] args) {
        System.out.println("Please enter any number: ");
        Scanner in = new Scanner(System.in);

        final String providedStrNumber = in.nextLine();
        System.out.println("You entered number " + providedStrNumber);

        LcdScreen lcdScreen = new LcdScreen();
        lcdScreen.display(providedStrNumber);
    }
}
