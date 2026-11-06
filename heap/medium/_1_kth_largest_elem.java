package heap.medium;

import java.util.PriorityQueue;

public class _1_kth_largest_elem {
    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        
        for(int num:nums){
            pq.add(num);
            if (pq.size()>k) {
                pq.remove();
            }
        }

        System.out.println(pq.peek());
    }
}
