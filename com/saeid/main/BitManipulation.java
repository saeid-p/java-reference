package com.saeid.main;

import java.util.BitSet;
import java.util.stream.IntStream;

public class BitManipulation {

  /*
   * (i & 1 << n) != 0 // checks bit 'n'
   * i |= 1 << n; // sets bit 'n' to 1
   * i &= ~(1 << n); // sets bit 'n' to 0
   * i ^= 1 << n; // toggles the value of bit 'n'
   */

  private static final long FIRST_BIT = 1L << 0;
  private static final long SECOND_BIT = 1L << 1;
  private static final long THIRD_BIT = 1L << 2;
  private static final long FOURTH_BIT = 1L << 3;
  private static final long FIFTH_BIT = 1L << 4;
  private static final long BIT_55 = 1L << 54;

  public void test(String[] args) {
    checkBitMask(FIRST_BIT | THIRD_BIT | FIFTH_BIT | BIT_55);

    /* If an integer x is a power of 2, only one bit is set, whereas x-1 has all bits set after that.
     For example: 4 is 100 and 3 is 011 as binary number, which satisfies the aforementioned condition.
     Zero is not a power of 2 and has to be checked explicitly. */
    int x = 8;
    boolean isPowerOfTwo = (x != 0) && ((x & (x - 1)) == 0);
    System.out.println(isPowerOfTwo ? "Is power of 2" : "Is not power of 2");
    /* Let’s suppose, we have three kind of permissions, READ, WRITE and EXECUTE. 
    Each permission can range from 0 to 7. (Let’s assume 4 bit number system)

    RESOURCE = READ WRITE EXECUTE (12 bit number)
    RESOURCE = 0100 0110 0101 = 4 6 5 (12 bit number)
    How can we get the (12 bit number) permissions, set on above (12 bit number)?

    0100 0110 0101
    0000 0000 0111 (&)
    0000 0000 0101 = 5

    So, this is how we can get the EXECUTE permissions of the RESOURCE. 
    Now, what if we want to get READ permissions of the RESOURCE?

    0100 0110 0101
    0111 0000 0000 (&)
    0100 0000 0000 = 1024

    Permissions are resulted in 1024. We want to get only READ permissions for the resource.
    Don’t worry, that’s why we had the shift operators. If we see, READ permissions are 8 bits 
    behind the actual result, so if apply some shift operator, which will bring READ permissions 
    to the very right of the result? What if we do:

    0100 0000 0000 >> 8 => 0000 0000 0100
    (Because it’s a positive number so replaced with 0’s, if you don't care about sign,
    just use unsigned right shift operator)

    We now actually have the READ permissions which is 4.
    Now, for example, we are given READ, WRITE, EXECUTE permissions for a RESOURCE, 
    what can we do to make permissions for this RESOURCE?

    Let’s first take the example of binary permissions. (Still assuming 4 bit number system)
    READ = 0001
    WRITE = 0100
    EXECUTE = 0110

    If you are thinking that we will simply do:
    READ | WRITE | EXECUTE, you are somewhat right but not exactly. See, what will happen if we will perform READ |
    WRITE | EXECUTE
    0001 | 0100 | 0110 => 0111
    But permissions are actually being represented (in our example) as 0001 0100 0110
    So, in order to do this, we know that READ is placed 8 bits behind, WRITE is placed 4 bits behind and PERMISSIONS
    is placed at the last. The number system being used for RESOURCE permissions is actually 12 bit (in our example). It
    can(will) be different in different systems.
    (READ << 8) | (WRITE << 4) | (EXECUTE)
    0000 0000 0001 << 8 (READ)
    0001 0000 0000 (Left shift by 8 bits)
    0000 0000 0100 << 4 (WRITE)
    0000 0100 0000 (Left shift by 4 bits)
    0000 0000 0001 (EXECUTE)
    Now if we add the results of above shifting, it will be something like;

    0001 0000 0000 (READ)
    0000 0100 0000 (WRITE)
    0000 0000 0001 (EXECUTE)
    0001 0100 0001 (PERMISSIONS)

    n Java, all number primitives are signed. For example, an int always represent values from [-2^31 - 1, 2^31], keeping
    the first bit to sign the value - 1 for negative value, 0 for positive.
    Basic shift operators >> and << are signed operators. They will conserve the sign of the value.
    But it is common for programmers to use numbers to store unsigned values. For an int, it means shifting the range
    to [0, 2^32 - 1], to have twice as much value as with a signed int.
    For those power users, the bit for sign as no meaning. That's why Java added >>>, a left-shift operator, disregarding
    that sign bit.

    initial value: 4 ( 100)
    signed left-shift: 4 << 1 8 ( 1000)
    signed right-shift: 4 >> 1 2 ( 10)
    unsigned right-shift: 4 >>> 1 2 ( 10)
    initial value: -4 ( 11111111111111111111111111111100)
    signed left-shift: -4 << 1 -8 ( 11111111111111111111111111111000)
    signed right-shift: -4 >> 1 -2 ( 11111111111111111111111111111110)
    unsigned right-shift: -4 >>> 1 2147483646 ( 1111111111111111111111111111110)

    Why is there no <<< ?
    This comes from the intended definition of right-shift. As it fills the emptied places on the left, there are no decision
    to take regarding the bit of sign. As a consequence, there is no need for 2 different operators.

    For expressing the power of 2 (2^n) of integers, one may use a bitshift operation that allows to explicitly specify the n.
    The syntax is basically:
    int pow2 = 1<<n;
    Examples:
    int twoExp4 = 1<<4; //2^4
    int twoExp5 = 1<<5; //2^5
    int twoExp6 = 1<<6; //2^6
    ...
    int twoExp31 = 1<<31; //2^31

    This is especially useful when defining constant values that should make it apparent, 
    that a power of 2 is used, instead of using hexadecimal or decimal values.

    int twoExp4 = 0x10; //hexadecimal
    int twoExp5 = 0x20; //hexadecimal
    int twoExp6 = 64; //decimal
    ...
    int twoExp31 = -2147483648; //is that a power of 2?
    A simple method to calculate the int power of 2 would be
    int pow2(int exp){
    return 1<<exp;
    }

    It is common for memory performance to compress multiple values into a single primitive value. This may be useful
    to pass various information into a single variable. For example, one can pack 3 bytes - such as color code in RGB - into an single int.
    
    Packing the values
    
    // Raw bytes as input
    byte[] b = {(byte)0x65, (byte)0xFF, (byte)0x31};
    
    // Packed in big endian: x == 0x65FF31
    int x = (b[0] & 0xFF) << 16 // Red
      | (b[1] & 0xFF) << 8 // Green
      | (b[2] & 0xFF) << 0; // Blue
    
    // Packed in little endian: y == 0x31FF65
    int y = (b[0] & 0xFF) << 0
      | (b[1] & 0xFF) << 8
      | (b[2] & 0xFF) << 16;
    
    Unpacking the values
    // Raw int32 as input
    int x = 0x31FF65;

    // Unpacked in big endian: {0x65, 0xFF, 0x31}
    byte[] c = {
      (byte)(x >> 16),
      (byte)(x >> 8),
      (byte)(x & 0xFF)
    };

    // Unpacked in little endian: {0x31, 0xFF, 0x65}
    byte[] d = {
      (byte)(x & 0xFF),
      (byte)(x >> 8),
      (byte)(x >> 16)
    };
    */
  }

  private void checkBitMask(long bitmask) {
    System.out.println("FIRST_BIT: " + ((bitmask & FIRST_BIT) != 0)); // true
    System.out.println("SECOND_BIT: " + ((bitmask & SECOND_BIT) != 0)); // false
    System.out.println("THIRD_BIT: " + ((bitmask & THIRD_BIT) != 0)); // true
    System.out.println("FOURTh_BIT: " + ((bitmask & FOURTH_BIT) != 0)); // false
    System.out.println("FIFTH_BIT: " + ((bitmask & FIFTH_BIT) != 0)); // true
    System.out.println("BIT_55: " + ((bitmask & BIT_55) != 0)); // true
  }

  private void bitSetClass() {
    final BitSet bitSet = new BitSet(8); // by default all bits are unset
    IntStream.range(0, 8).filter(i -> i % 2 == 0).forEach(bitSet::set); // {0, 2, 4, 6}
    bitSet.set(3); // {0, 2, 3, 4, 6}
    bitSet.set(3, false); // {0, 2, 4, 6}
    final boolean b = bitSet.get(3); // b = false
    bitSet.flip(6); // {0, 2, 4}
    bitSet.set(100); // {0, 2, 4, 100} - expands automatically

    bitSet.and(new BitSet(8));
    bitSet.or(new BitSet(8));
    bitSet.xor(new BitSet(8));
    bitSet.andNot(new BitSet(8));
  }
}
