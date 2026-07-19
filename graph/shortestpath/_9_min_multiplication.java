package graph.shortestpath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _9_min_multiplication {
    public static void main(String[] args) {
        int arr[] = {2, 5, 7};
        int start = 3, end = 30;
        // Output:
        // 2
        // Explanation: 
        // Step 1: 3*2 = 6 % 100000 = 6 
        // Step 2: 6*5 = 30 % 100000 = 30

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        int d[] = new int[end+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.peek()[0];
            int step = queue.peek()[1];

            for(int it:arr){
                int num = curr*it;
                if (num<=end) {
                    if (step+1<d[num]) {
                        d[num] = step+1;
                        if (num==end) {
                            break;
                        }
                        queue.add(new int[]{num, d[num]});
                    }
                }
            }
        }

        System.out.println(d[end]);
    }
}
