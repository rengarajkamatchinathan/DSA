package greedy.medium;

import java.util.Arrays;

public class _9_non_overlapping_intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        //op = 1

        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));

        int lastInterval = intervals[0][1];
        int cnt = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>=lastInterval) {
                lastInterval = intervals[i][1];
            }
            else{
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
