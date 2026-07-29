package dp._subsequence;

public class _8_target_sum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1}; 
        int target = 3;
        // Output: 5
        // Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
        // -1 + 1 + 1 + 1 + 1 = 3
        // +1 - 1 + 1 + 1 + 1 = 3
        // +1 + 1 - 1 + 1 + 1 = 3
        // +1 + 1 + 1 - 1 + 1 = 3
        // +1 + 1 + 1 + 1 - 1 = 3
        /*
        qn is about placing + or - before each number. then cnt ways for target.
        lets say if u place sign like +1-1-1+1 , eventually it became like +2 - 2.
        then it come under same prob like
        s1 - s2 = d
        */
    }
}
