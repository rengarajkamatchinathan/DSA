
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_merge_intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        // Output: [[1,6],[8,10],[15,18]]

        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));

        for(int interval[]:intervals){
            if (res.isEmpty() || interval[0] > res.get(0).get(1)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(interval[0]);
                tmp.add(interval[1]);
                res.add(tmp);
            }
            else{
                //why max?
                //what if, (1,3),(2,2) . here end 3 is greater
                int maxEnd = Math.max(interval[1], res.get(0).get(1));
                res.get(res.size()-1).set(1, maxEnd);
            }
        }

        System.out.println(res);
    }
}
