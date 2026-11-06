package greedy.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _1_n_meetings_one_room {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,5,7,9,9};
        // Output: [1, 2, 4, 5]

        List<int[]> meetings = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meetings.add(new int[]{start[i], end[i], i+1});
        }

        meetings.sort(Comparator.comparingInt(a->a[1]));

        int lastEnd = -1;
        List<Integer> res = new ArrayList<>();

        for(int[] meeting:meetings){
            if (meeting[0]>lastEnd) {
                lastEnd = meeting[1];
                res.add(meeting[2]);
            }
        }

        System.out.println(res);
    }
}
