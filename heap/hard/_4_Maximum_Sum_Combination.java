package heap.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class _4_Maximum_Sum_Combination {
    public static void main(String[] args) {
        int[] nums1 = {7, 3};
        int[] nums2 = {1, 6};
        int k = 2;
        //  Output : [13, 9]
        //  Explanation : The 2 maximum combinations are made by: nums1[0] + nums2[1] = 13
        //  nums1[1] + nums2[1] = 9

        //1.Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        Set<String> vis = new HashSet<>();

        //We guarantee this is the first max combination
        pq.offer(new int[]{nums1[nums1.length-1] + nums2[nums2.length-1], nums1.length-1, nums2.length-1});
        vis.add((nums1.length-1)+","+(nums2.length-1));

        List<Integer> res = new ArrayList<>();

        while (k-->0 && !pq.isEmpty()) {
            int cur[] = pq.poll();
            int sum = cur[0];
            int i = cur[1];
            int j = cur[2];
            
            res.add(sum);

            if(i-1>=0){
                String key = (i-1)+","+(j);
                if (!vis.contains(key)) {
                    pq.add(new int[]{nums1[i-1]+nums2[j], i-1, j});
                    vis.add(key);
                }
            }

            if(j-1>=0){
                String key = (i)+","+(j-1);
                if (!vis.contains(key)) {
                    pq.add(new int[]{nums1[i]+nums2[j-1], i, j-1});
                    vis.add(key);
                }
            }
        }
    }
}
