
import java.util.PriorityQueue;

public class _2_min_cost_to_connect_sticks {
    public static void main(String[] args) {
        int[] sticks = {1,8,3,5};
        // Output: 30
        // Explanation: You start with sticks = [1,8,3,5].
        // 1. Combine sticks 1 and 3 for a cost of 1 + 3 = 4. Now you have sticks = [4,8,5].
        // 2. Combine sticks 4 and 5 for a cost of 4 + 5 = 9. Now you have sticks = [9,8].
        // 3. Combine sticks 9 and 8 for a cost of 9 + 8 = 17. Now you have sticks = [17].
        // There is only one stick left, so you are done. The total cost is 4 + 9 + 17 = 30.

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int it:sticks){
            pq.add(it);
        }

        int tot = 0;
        while (pq.size()>1) {
            int tmp = pq.poll() + pq.poll();
            tot += tmp;
            pq.add(tmp);
        }

        System.out.println(tot);
    }
}
