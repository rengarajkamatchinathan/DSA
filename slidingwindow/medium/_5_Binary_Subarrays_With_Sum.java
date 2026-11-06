public class _5_Binary_Subarrays_With_Sum {
    public static void main(String[] args) {
        int nums[] = {1, 0, 0, 1, 1, 0}; 
        int goal = 2;  
        // Output: 7

        System.out.println(atmost(goal, nums) - atmost(goal-1, nums));
    }

static int atmost(int n, int nums[]) {
    int cnt = 0;
    int left = 0, right = 0;
    int sum = 0;

    while (right < nums.length) {
        sum += nums[right];

        while (sum > n) {
            sum -= nums[left];
            left++;
        }

        cnt += (right - left + 1);
        right++;
    }

    return cnt;
}
}
