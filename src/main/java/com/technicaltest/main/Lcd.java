package com.technicaltest.main;

import com.technicaltest.exceptions.InputValidationException;
import com.technicaltest.lcdscreen.LcdDisplay;
import com.technicaltest.lcdscreen.LcdDisplayImpl;

import java.util.Scanner;

public class Lcd {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Please enter any number to display on screen: ");
            Scanner in = new Scanner(System.in);

            final String providedStrNumber = in.nextLine();

            LcdDisplay lcdDisplay = new LcdDisplayImpl();
            try {
                lcdDisplay.displayNumber(providedStrNumber);
            } catch (InputValidationException ex) {
                ex.printStackTrace();
            }
        }
    }
}
