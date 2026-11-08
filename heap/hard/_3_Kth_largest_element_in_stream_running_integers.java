
import java.util.PriorityQueue;

class KthLargest{
    PriorityQueue<Integer> pq;
    int K;
    KthLargest(int k, int arr[]){
        this.K = k;
        pq = new PriorityQueue<>((a,b)->a-b);
        for(int it:arr){
            pq.offer(it);
            if (pq.size()>K) {
                pq.poll();
            }
        }
    }

    int add(int num){
        pq.offer(num);
        
        if (pq.size()>K) {
            pq.poll();
        }

        return pq.peek();
    }
}
public class _3_Kth_largest_element_in_stream_running_integers {
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));   // Output: 4
        System.out.println(kthLargest.add(5));   // Output: 5
        System.out.println(kthLargest.add(10));  // Output: 5
        System.out.println(kthLargest.add(9));   // Output: 8
        System.out.println(kthLargest.add(4));   // Output: 8
    }
}
