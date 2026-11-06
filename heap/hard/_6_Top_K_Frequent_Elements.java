package heap.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _6_Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int key:freq.keySet()){
            minHeap.offer(new int[]{freq.get(key),key});
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i] = minHeap.poll()[1];
        }

        return res;
    }
    public static void main(String[] args) {
        
    }
}
