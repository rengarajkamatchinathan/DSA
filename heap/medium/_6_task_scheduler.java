package heap.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _6_task_scheduler {
    public static void main(String[] args) {
        
        char[] tasks = {'A','C','A','B','D','B'};
        int n = 1;
        // Output : 6

        //FREQUENCY
        Map<Character, Integer> hMap = new HashMap<>();
        for(char c:tasks){
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        }

        //PUT FREQUENCIES INTO PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int t:hMap.values()){
            pq.add(t);
        }

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();

            int cycle = n+1;
            int i = 0;

            while (i<cycle && !pq.isEmpty()) {
                int count = pq.poll();
                count--;
                if (count>0) {
                    tmp.add(count);
                }
                time++;
                i++;
            }

            //For idle increase time
            if (!pq.isEmpty()) {
                time += cycle-i;
            }

            //add back remaining tasks into pq
            for(int rem:tmp){
                pq.add(rem);
            }
        }

        System.out.println(time);
    }
}
