package bitmanipulation.problems;

import java.util.ArrayList;
import java.util.List;

public class _4_power_set_bit_multiplication {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        // Output : [ 
        // [ ] , [1] , [2] , [1, 2] , [3] , [1, 3] , [2, 3] , [1, 2 ,3] ]

        // There are 2³ = 8 possible subsets.
        // Each subset can be represented by a 3-bit number:
        // 000
        // 001
        // 010
        // 011
        // 100
        //...

        //Each bit decides whether an element is included:
        // bit 2   bit 1   bit 0
        // ↓       ↓       ↓
        // c       b       a

        List<List<Integer>> ans = new ArrayList<>();
        for(int mask=0;mask<(1<<nums.length);mask++){
            List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if((mask&(1<<i))!=0){
                    tmp.add(nums[i]);
                }
            }
            ans.add(tmp);
        }

        System.out.println(ans);
    }
}
