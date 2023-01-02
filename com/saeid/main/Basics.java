package com.saeid.main;

import java.util.Locale;
import java.time.Instant;

public class Basics {
    public static void main(String[] args) {
        int counter = 5;
        while (counter > 0) {
            counter--;
        }

        int[] myArray = new int[5];
        do {
            myArray[counter++] = counter;
        } while (counter != myArray.length);

        for (int i = 0; i < myArray.length; i++) {
            ++myArray[i];
        }

        int total = 0;
        // ForEach loops:
        for (int value : myArray) {
            total += value;
        }
    }

    private static void workingWithTypes() {
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

        char charValue = Character.MIN_VALUE;
        char charValueAssigned = 'X';
        String stringValue = "Test";
        stringValue = stringValue.trim().toLowerCase().toUpperCase();

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

        /*
         * In Java, we can convert between integer values and floating-point values.
         * Also, since every character corresponds to a number in the Unicode encoding,
         * char types can be converted to and from the integer and floating-point types.
         * boolean is the only primitive datatype that cannot be converted to or from
         * any other primitive datatype.
         */

        /*
         * boolean Boolean 1 byte / 16 bytes
         * byte Byte 1 byte / 16 bytes
         * short Short 2 bytes / 16 bytes
         * char Char 2 bytes / 16 bytes
         * int Integer 4 bytes / 16 bytes
         * long Long 8 bytes / 16 bytes
         * float Float 4 bytes / 16 bytes
         * double Double 8 bytes / 16 bytes
         */

        /*
         * Boxed objects always require 8 bytes for type and memory management, and
         * because the size of objects is always a multiple of 8, boxed types all
         * require 16 bytes total.
         * In addition, each usage of a boxed object entails storing a reference which
         * accounts for another 4 or 8 bytes, depending on the JVM and JVM options.
         * In data-intensive operations, memory consumption can have a major impact on
         * performance. Memory consumption grows even more when using arrays: a float[5]
         * array will require only 32 bytes; whereas a Float[5] storing 5 distinct
         * non-null values will require 112 bytes total (on 64 bit without compressed
         * pointers, this increases to 152 bytes).
         */
    }

    private static void workingWithStrings() {
        // See formats here:
        // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
        String formatted = String.format(Locale.US, "$,d", 10000);

        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilt = stringBuilder.append("str 1").append("str 2").toString();

        String strObj = new String("Hello!");
        String str1 = "Hello!";
        String str2 = "Hello!";

        if (strObj.equals(str1)) {
            System.out.println("strObj.equals(str1)");
        }

        if (strObj != str1) {
            System.out.println("strObj != str1");
        }

        if (str1 == str2) {
            System.out.println("str1 == str2");
        }

        // If we intern a string that is equal to a given literal, the result is
        // a string that has the same reference as the literal.
        String internedStr = strObj.intern();
        if (internedStr == str1) {
            System.out.println("internedStr == str1");
        }
    }

    private static void workingWithDates() {
        Instant now = Instant.now();
    }

    private static Boolean typeChecking() {
        Object baseClass = new TestBaseClass();
        // Type checking:
        if (baseClass instanceof TestBaseClass) {
            return true;
        }
        return false;
    }

    private static void underScoreUsage() {
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