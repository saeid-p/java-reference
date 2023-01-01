package com.saeid.main;

import java.util.Locale;
import java.time.Instant;

public class Basics {
    public static void main(String[] args) {
        boolean boolValue = Boolean.TRUE; // or set to true

        byte byteValue = Byte.MAX_VALUE;
        short shortValue = Short.MAX_VALUE;
        int intValue = Integer.MAX_VALUE;
        long longValue = Long.MAX_VALUE;

        float floatValue = 42.195f;
        float floatValueMax = Float.MAX_VALUE;
        double doubleValue = 0.0d;
        double doubleValueMax = Double.MAX_VALUE;

        int dec = 110; // no prefix --> decimal literal
        int bin = 0b1101110; // '0b' prefix --> binary literal
        int oct = 0156; // '0' prefix --> octal literal
        int hex = 0x6E; // '0x' prefix --> hexadecimal literal
        // The octal literal can easily be a trap for semantic errors. If you define a
        // leading '0' to your decimal literals you will get the wrong value:
        int a = 0100; // Instead of 100, a == 64

        int counter = 5;
        while (counter > 0) {
            System.out.println(counter--);
        }

        int[] myArray = new int[5];
        do {
            myArray[counter++] = counter;
        } while (counter != myArray.length);

        // ForEach loops:
        for (int value : myArray) {
            System.out.println(value);
        }

        char charValue = Character.MIN_VALUE;
        char charValueAssigned = 'X';
        String stringValue = "Test";
        System.out.println(stringValue.trim().toLowerCase().toUpperCase());

        int stringLength = stringValue.length();
        String stringConcat = stringValue.concat("Another String");
        String stringReplaced = stringValue.replace("Test", "Replaced");
        String[] splittedString = "A,B,C".split(",");
        char charAt = stringValue.charAt(0);
        int indexOf = stringValue.indexOf("T");
        String substring = stringValue.substring(0, 3);
        boolean contains = stringValue.contains("A");
        boolean isEmpty = stringValue.isEmpty();
        boolean areEqual = stringValue.equals("Test");
        boolean areEqualCI = stringValue.equalsIgnoreCase("test");
        int compareTo = stringValue.compareTo("Test");
        int compareToCI = stringValue.compareToIgnoreCase("Test");

        // See formats here:
        // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
        String formatted = String.format(Locale.US, "$,d", 10000);

        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilt = stringBuilder.append("str 1").append("str 2").toString();

        Instant now = Instant.now();
    }

    private void typeChecking() {
        Object baseClass = new TestBaseClass();
        // Type checking:
        if (baseClass instanceof TestBaseClass) {
            System.out.println("It is!");
        }
    }

    private void underScoreUsage() {
        byte color = 1_2_3;
        short yearsAnnoDomini = 2_016;
        int socialSecurtyNumber = 999_99_9999;
        long creditCardNumber = 1234_5678_9012_3456L;
        float piFourDecimals = 3.14_15F;
        double piTenDecimals = 3.14_15_92_65_35;

        // This also works using prefixes for binary, octal and hexadecimal bases.
        // (Version ≥ Java SE 7)
        short binary = 0b0_1_0_1;
        int octal = 07_7_7_7_7_7_7_7_0;
        long hexBytes = 0xFF_EC_DE_5E;

        // There are forbidden places to use underscores:
        // At the beginning or end of a number (e.g. _123 or 123_ are not valid)
        // Adjacent to a decimal point in a floating point literal (e.g. 1._23 or 1_.23)
        // Prior to an F or L suffix (e.g. 1.23_F or 9999999_L are not valid)
        // In positions where a string of digits is expected (e.g. 0_xFFFF is not valid)

    }
}