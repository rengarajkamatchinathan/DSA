public class _6_nos_of_nice_subarrays {
    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 1, 1};
        int k = 3;
        // Output :2
        // Explanation :The subarrays with three odd numbers are [1, 1, 2, 1] [1, 2, 1, 1]

        System.out.println(atmost(k, nums) - atmost(k-1, nums));
    }   
    
    static int atmost(int k, int nums[]){
        int left = 0, right = 0;
        int cnt = 0;

        while (right<nums.length) {
            if (nums[right]%2!=0)
                k--;

            while (k<0) {
                if(nums[left]%2!=0)
                    k++;
                left++;
            }

            cnt += (right-left+1);
            right++;
        }

        return cnt;
    }
}