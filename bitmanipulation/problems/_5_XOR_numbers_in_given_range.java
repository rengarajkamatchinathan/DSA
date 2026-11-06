package bitmanipulation.problems;

public class _5_XOR_numbers_in_given_range {
    public static void main(String[] args) {
        int L = 3, R = 6;
        int xor = xor1ToN(R) - xor1ToN(L-1);
    }
    
    static int xor1ToN(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0;
    }
}
