package stackandqueue._4_implementations;

import java.util.Deque;
import java.util.LinkedList;

public class _1_sliding_window_maximum {
    public static void main(String[] args) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            
            //Maintain Decreasing order from normal queue.
            //1,3,5
            while (!q.isEmpty() && nums[q.peek()]<nums[i]) {
                q.pollLast();
            }
            q.add(i);
        }
    }
}
