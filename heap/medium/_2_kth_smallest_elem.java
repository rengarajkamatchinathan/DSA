package heap.medium;

import java.util.PriorityQueue;

public class _2_kth_smallest_elem {
    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int num:nums){
            pq.add(num);
            if (pq.size()>k) {
                pq.remove();
            }
        }

        System.out.println(pq.peek());
    }
}
