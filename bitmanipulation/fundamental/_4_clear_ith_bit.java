package bitmanipulation.fundamental;

public class _4_clear_ith_bit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        //1101 -> 1001

        //1101= 1101
        //0100->1011

        //obvious cant do anything by moving 1 to ith bit on left side
        //what if u flip all bits on downside
        //1 and 0(ith bit) transformed to 0 if u do AND
        //1 and 1 stays 1
        n = (n & ~(1<<i));
    }
}
