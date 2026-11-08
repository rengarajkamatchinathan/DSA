
public class _2_jump_game_2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        // Output: 2
        // Explanation: The minimum number of jumps to reach the last index is 2. 
        // Jump 1 step from index 0 to 1, then 3 steps to the last index.

        int maxJumpRangeIndex = 0;
        int jumps = 0;
        int maxi = 0;

        for (int i = 0; i < nums.length; i++) {
            
            maxi = Math.max(maxi, nums[i] + i);
            
            if (i==maxJumpRangeIndex) {
                jumps++;
                maxJumpRangeIndex = maxi;
            }
        }

        System.out.println(jumps);
    }
}
