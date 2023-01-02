package com.saeid.main;

import java.util.Locale;
import java.util.function.Function;
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
        char charValue = Character.MIN_VALUE;
        char charValueAssigned = 'X';

        // See formats here:
        // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
        String formatted = String.format(Locale.US, "$,d", 10000);

        /*
         * Since it is very unlikely that the new line separator changes during the
         * program's execution, it is a good idea to store it in in a static variable.
         */
        String lineSeparator = System.lineSeparator();

        /*
         * The StringBuffer is used to created mutable strings.
         * The StringBuilder class is the same as StringBuffer except that it is
         * non-synchronized and hence thread-safe.
         */
        StringBuffer strB = new StringBuffer("study");
        strB.append("tonight");

        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilt = stringBuilder.append("str 1").append("str 2").toString();

        String stringValue = "Test";
        stringValue = stringValue.trim().toLowerCase().toUpperCase();

        int stringLength = stringValue.length();
        String stringConcat = stringValue.concat("Another String");
        String stringReplaced = stringValue.replace("Test", "Replaced");

        String[] splittedString = "A,B,C".split(",");
        /*
         * split(delimiter) by default removes trailing empty strings from result array.
         * To turn this mechanism off we need to use overloaded version of
         * split(delimiter, limit) with limit set to negative value.
         * The limit parameter controls the number of times the pattern is applied and
         * therefore affects the length of the resulting array.
         * If the limit n is greater than zero then the pattern will be applied at most
         * n - 1 times, the array's length will be no greater than n, and the array's
         * last entry will contain all input beyond the last matched delimiter.
         * If n is negative, then the pattern will be applied as many times as possible
         * and the array can have any length.
         * If n is zero then the pattern will be applied as many times as possible, the
         * array can have any length, and trailing empty strings will be discarded.
         */
        String[] split = "a,b,c ".split(",", -1);
        // See: https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html

        char charAt = stringValue.charAt(0);
        int indexOf = stringValue.indexOf("T");
        String substring = stringValue.substring(0, 3);
        boolean contains = stringValue.contains("A");
        boolean isEmpty = stringValue.isEmpty();
        boolean areEqual = stringValue.equals("Test");
        boolean areEqualCI = stringValue.equalsIgnoreCase("test");
        int compareTo = stringValue.compareTo("Test");
        int compareToCI = stringValue.compareToIgnoreCase("Test");

        String[] elements = { "foo", "bar", "foobar" };
        String singleString = String.join(" + ", elements);
        // See: https://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html

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

        /*
         * Like many Java objects, all String instances are created on the heap, even
         * literals. When the JVM finds a String literal that has no equivalent
         * reference in the heap, the JVM creates a corresponding String instance on the
         * heap and it also stores a reference to the newly created String instance in
         * the String pool. Any other references to the same String literal are replaced
         * with the previously created String instance in the heap.
         * 
         * Using new operator, we force String class to create a new String object in
         * heap space. We can use intern() method to put it into the pool or refer to
         * other String object from string pool having same value.
         */

        /*
         * In JDK 7, interned strings are no longer allocated in the permanent
         * generation of the Java heap, but are instead allocated in the main part of
         * the Java heap (known as the young and old generations), along with
         * the other objects created by the application. This change will result in more
         * data residing in the main Java heap, and less data in the permanent
         * generation, and thus may require heap sizes to be adjusted.
         * Most applications will see only relatively small differences in heap usage
         * due to this change, but larger applications that load many classes or make
         * heavy use of the String.intern() method will face significant differences.
         */
    }

    private static void workingWithStringBuffers() {

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