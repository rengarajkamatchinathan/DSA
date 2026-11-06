package slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class _2_Subarray_with_k_different_integers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;  
        // Output: 7
        // Explanation: The 7 subarrays with exactly 2 different integers are:
        // [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
        System.out.println(atmost(k, nums) - atmost(k-1, nums));
    }

    static int atmost(int n, int nums[]){
        int left = 0, right = 0, cnt = 0;
        Map<Integer, Integer> hMap = new HashMap<>();

        while (right<nums.length) {
            hMap.put(nums[right], hMap.getOrDefault(nums[right], 0)+1);
            if (hMap.get(nums[right])==1) {
                n--;
            }

            while (n<0) {
                hMap.put(nums[left], hMap.get(nums[left])-1);
                if (hMap.get(nums[left])==0) {
                    hMap.remove(nums[left]);
                    n++;
                }
                left++;
            }
            cnt += (right-left+1);
            
            right++;
        }


        // while (right<nums.length) {
        //     hMap.put(nums[right], hMap.getOrDefault(nums[right], 0)+1);

        //     while (hMap.size()>n) {
        //         hMap.put(nums[left], hMap.get(nums[left])-1);
        //         if (hMap.get(nums[left])==0) {
        //             hMap.remove(nums[left]);
        //         }
        //         left++;
        //     }
        //     cnt += (right-left+1);
            
        //     right++;
        // }

        return  cnt;
    }
}
