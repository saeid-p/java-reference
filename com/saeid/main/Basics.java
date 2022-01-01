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

        int counter = 5;
        while (counter > 0) {
            System.out.println(counter--);
        }

        int[] myArray = new int[5];
        do {
            myArray[counter++] = counter;
        } while (counter != myArray.length);

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
        
        // See formats here: https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
        String formatted = String.format(Locale.US, "$,d", 10000);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("str 1").append("str 2");
        String stringBuilt = stringBuilder.toString();

        Instant now = Instant.now();
        
    }
}