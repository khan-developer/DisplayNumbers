package com.technicaltest.main;

import com.technicaltest.lcdscreen.LcdDisplayImpl;

import java.util.Scanner;

public class Lcd {


    public static void main(String[] args) {
        System.out.println("Please enter any number to display on screen: ");
        Scanner in = new Scanner(System.in);

        final String providedStrNumber = in.nextLine();
        System.out.println("You entered number " + providedStrNumber);

        LcdDisplayImpl displayNumbersImpl = new LcdDisplayImpl();
        displayNumbersImpl.displayNumber(providedStrNumber);
    }
}
