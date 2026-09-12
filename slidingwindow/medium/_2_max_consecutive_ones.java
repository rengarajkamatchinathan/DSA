package slidingwindow.medium;

public class _2_max_consecutive_ones {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 3;
        // Output : 10

        int l = 0, r = 0, zeroCnt = 0, maxi = -1;

        while (r<nums.length) {
            if (nums[r]==0) {
                zeroCnt++;
            }

            if (zeroCnt>k) {
                if (nums[l]==0) {
                    zeroCnt--;
                }
                l++;
            }

            maxi = Math.max(maxi, r-l+1);
            r++;
        }

        System.out.println(maxi);
    }
}
