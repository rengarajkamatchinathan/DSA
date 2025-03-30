import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String args[]) {
        int numCourses = 2;
        int[][]prerequisites = {
            {1,0},
            {0,1}
        };
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList());
        }
        for(int arr[] : prerequisites){
            adj.get(arr[0]).add(arr[1]);
        }
        
        int[] ind = new int[numCourses];
        for(int i=0;i<adj.size();i++){
            for(int j : adj.get(i)){
                // 
                ind[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int i : adj.get(node)){
                ind[i]--;
                if(ind[i]==0){
                    q.add(i);
                }
            }
        }

        System.out.println(res.size()==adj.size());
        
    }
    
}
