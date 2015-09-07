/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class NumberConverter {

    /**
     * @param args the command line arguments
     */
    private static Scanner keyboard = new Scanner(System.in);
    private static String octalInput = "";

    public static void main(String[] args) {

        NumberConverter mainClass = new NumberConverter();
       
        while (true) {
            mainClass.showDescription();
            ArrayList dummyInput = mainClass.getOctalInput();
            String input = mainClass.getChoiceInput();

            if (input.equalsIgnoreCase("hex")) {
                System.out.println(mainClass.getHexNumber(dummyInput));
            } else if (input.equalsIgnoreCase("binary")) {
                System.out.println(mainClass.getBinaryNumber(dummyInput));
            }
            mainClass.getAnotherConversion();
        } //end while
    }// end main

    public static void showDescription() {

        System.out.printf("This program converts an octal input %n"
                + "number to a hexadecimal or binary number. %n"
                + "The program user is prompted for the ocatal  number %n"
                + "and for the conversion type.  Error messages are written %n"
                + "if any of the inputs are incorrect or out of range. %n"
                + "If there is an input error a loop continues to ask for %n"
                + "correct input until correct input is provided. %n");

    }// showDescription

    public static void getAnotherConversion() {

        System.out.println("Another conversion? Type Yes or No: ");
        String decision = keyboard.nextLine();
        if (decision.equalsIgnoreCase("yes")) {
        } else {
            System.exit(0);
        }
    }// end getConversion

    public static ArrayList getOctalInput() {
        boolean sentinel = true;
        // String octalInput = "";
        ArrayList octalArray = new ArrayList();

        do {
            System.out.println("\nInput an octal number.");
            octalInput = keyboard.nextLine();

            if (octalInput.matches("^[0-7][0-7]*$")) {
                sentinel = false;

                for (int i = 0; i < octalInput.length(); i++) {
                    char octalChar = octalInput.charAt(i);
                    octalArray.add(octalChar);
                }
            } else {
                System.out.println("Incorrect octal input...re-enter number.");
                sentinel = true;
            }

        } while (sentinel);

        return octalArray;

    }// end getOctalInput

    public static String getChoiceInput() {

        boolean sentinel = true;
        String conversionType = "";
        String choiceInput = "";
        do {

            String hex = "hex";

            System.out.println("Enter the conversion type(Binary or Hex): ");
            conversionType = keyboard.nextLine();

            if (conversionType.equalsIgnoreCase("hex")) {
                sentinel = false;
                choiceInput = "hex";

            } else if (conversionType.equalsIgnoreCase("binary")) {
                sentinel = false;
                choiceInput = "binary";

            } else {
                sentinel = true;
                System.out.println("Incorrect conversion input...reenter choice.");

            }

        } while (sentinel);

        return choiceInput;

    }// end getChoiceInput

    public static String octalToBinary(ArrayList octalInput) {

        String octZero = "000";
        String octOne = "001";
        String octTwo = "010";
        String octThree = "011";
        String octFour = "100";
        String octFive = "101";
        String octSix = "110";
        String octSeven = "111";

        ArrayList binaryArray = new ArrayList();
        StringBuilder binaryStringBuilder = null;
        StringBuilder binaryOut = null;

        for (int i = 0; i < octalInput.size(); i++) {

            if (octalInput.get(i).equals('0')) {
                //System.out.println(octZero);
                binaryArray.add(octZero);
            } else if (octalInput.get(i).equals('1')) {
                //  System.out.println(octOne);
                binaryArray.add(octOne);
            } else if (octalInput.get(i).equals('2')) {
                //  System.out.println(octTwo);
                binaryArray.add(octTwo);
            } else if (octalInput.get(i).equals('3')) {
                //  System.out.println(octThree);
                binaryArray.add(octThree);
            } else if (octalInput.get(i).equals('4')) {
                //  System.out.println(octFour);
                binaryArray.add(octFour);
            } else if (octalInput.get(i).equals('5')) {
                //   System.out.println(octFive);
                binaryArray.add(octFive);
            } else if (octalInput.get(i).equals('6')) {
                //  System.out.println(octSix);
                binaryArray.add(octSix);
            } else if (octalInput.get(i).equals('7')) {
                //   System.out.println(octSeven);
                binaryArray.add(octSeven);
            }

            String formatedString = binaryArray.toString();
            String output = formatedString.replace(",", "").replace("[", "")
                    .replace("]", "").replace(" ", "").trim();

            binaryStringBuilder = new StringBuilder(output);

            char paddingZeros = 0;
            binaryOut = new StringBuilder();

            do {
                binaryOut = binaryStringBuilder.insert(paddingZeros, 0);

            } while (binaryOut.length() % 4 != 0);
        }

        return binaryOut.toString();
    } // end toBinary

    public static String getBinaryNumber(ArrayList binaryArray) {
        String out = octalToBinary(binaryArray).toString();

        return "The octal number " + octalInput + " converted to BINARY is "
                + out.replaceFirst("^0+(?!$)", "").trim();

    }// end getBinaryNumber

    public static String getHexNumber(ArrayList binaryArray) {

        ArrayList hexArrayOutput = new ArrayList();
        ArrayList hexOutput = new ArrayList();
        String binaryOut = octalToBinary(binaryArray);

        int start = 0;
        int end = 4;

        while (end <= binaryOut.length()) {

            hexArrayOutput.add(binaryOut.substring(start, end));
            start += 4;
            end += 4;
        }

        for (int i = 0; i < hexArrayOutput.size(); i++) {
            if (hexArrayOutput.get(i).equals("0000")) {
                hexOutput.add("0");
            } else if (hexArrayOutput.get(i).equals("0001")) {
                hexOutput.add("1");
            } else if (hexArrayOutput.get(i).equals("0010")) {
                hexOutput.add("2");
            } else if (hexArrayOutput.get(i).equals("0011")) {
                hexOutput.add("3");
            } else if (hexArrayOutput.get(i).equals("0100")) {
                hexOutput.add("4");
            } else if (hexArrayOutput.get(i).equals("0101")) {
                hexOutput.add("5");
            } else if (hexArrayOutput.get(i).equals("0110")) {
                hexOutput.add("6");
            } else if (hexArrayOutput.get(i).equals("0111")) {
                hexOutput.add("7");
            } else if (hexArrayOutput.get(i).equals("1000")) {
                hexOutput.add("8");
            } else if (hexArrayOutput.get(i).equals("1001")) {
                hexOutput.add("9");
            } else if (hexArrayOutput.get(i).equals("1010")) {
                hexOutput.add("A");
            } else if (hexArrayOutput.get(i).equals("1011")) {
                hexOutput.add("B");
            } else if (hexArrayOutput.get(i).equals("1100")) {
                hexOutput.add("C");
            } else if (hexArrayOutput.get(i).equals("1101")) {
                hexOutput.add("D");
            } else if (hexArrayOutput.get(i).equals("1110")) {
                hexOutput.add("E");
            } else if (hexArrayOutput.get(i).equals("1111")) {
                hexOutput.add("F");
            }
        }

        String formatedString2 = hexOutput.toString();
        String output2 = formatedString2.replace(",", "").replace("[", "")
                .replace("]", "").replace(" ", "").trim().replaceFirst("^0+(?!$)", "");

        return "The octal number " + octalInput + " converted to HEX is " + output2;

    }// end getHexNumber
} // end class
