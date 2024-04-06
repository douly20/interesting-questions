/**
 * Given a binary string representation of a number , you have to do operations on it until it becomes 0.
 * The operations are :
 * 1. If the number is odd - subtract 1
 * 2.If the number is even - Divide by 2
 * Count the total number of operations to make it 0
 */
public class BitManipulationInStringQuestion {
    private static final int start = 0;
    public static int end = -1;

    public static void countOperations(String binary) {
        int count = 0;
        char[] ch = binary.toCharArray();
        end = ch.length - 1;
        while (!isZero(ch)) {
            if (isOdd(ch)) {
                subtract(ch);
            } else {
                divide();
            }
            count++;
        }
        System.out.println("Count is " + count);

    }

    private static boolean isOdd(char[] s) {
        int bit = s[end] == '0' ? 0 : 1;
        return (bit & 1) == 1;
    }

    private static void divide() {
        end--;
    }

    private static void subtract(char[] s) {
        int bit = s[end] == '0' ? 0 : 1;
        int ans = bit ^ 1;
        char ch = ans == 1 ? '1' : '0';
        s[end] = ch;
    }

    private static boolean isZero(char[] s) {
        for (int i = start; i <= end; i++) {
            if (s[i] != '0')
                return false;
        }
        return true;
    }

    /**
     * Learning from this solution - If the string is very large , don't cast it to Integer, BigInteger it won't work.
     * Also while doing operations avoid String manipulations as it costs a lot. Here we used pointers which resulted in O(1) operations
     */
    private static void learning() {

    }

}

