package stackandqueue._3_monotonic_stack;

public class _6_sum_of_subarray_minimum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};
        // Output:
        //  18
        // Explanation:
        //  The minimum of subarrays: 
        // [3], [1], [2], [5], [3, 1], [1, 2], 
        // [2, 5], [3, 1, 2], [1, 2, 5], [3, 1, 2, 5] 
        // are 3, 1, 2, 5, 1, 1, 2, 1, 1, 1 respectively and their sum is 18.
    }    
}