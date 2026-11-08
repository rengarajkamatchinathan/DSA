
public class _3_single_number_III {
    public static void main(String[] args) {
        int nums[] = {1,2,1,3,2,5};

        int xor = 0;

        // XOR all numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Get rightmost set bit
        int bit = xor & -xor;

        int a = 0;
        int b = 0;

        // Divide into two groups
        //Now we one bit differentiation position especially right most set bit.
        //while iterating if that bit occuring element found put into one group and remaining into another group
        //also like similar rightmost bits pattern elements also might moved into group
        //but no problem they have duplicates
        for (int num : nums) {
            if ((num & bit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
    }
}
