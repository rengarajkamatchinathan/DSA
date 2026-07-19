package graph.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _4_course_schedule1 {
    public static void main(String[] args) {
        int arr[][] = {{1,0}};
        int V = 2;
        //op: yes       
        List<List<Integer>> adj = new ArrayList<>();
        int indeg[] = new int[V];
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int a[]:arr){
            int u = a[0];
            int v = a[1];
            adj.get(u).add(v);
        }

        //1.indegree form
        for (int i = 0; i < V; i++) {
            for(int j:adj.get(i)){
                indeg[j]++;
            }
        }

        //2.indeg 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]==0) {
                queue.add(i);
            }
        }

        //3.cnt if valid DAG without LOOP
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;

            for(int child:adj.get(node)){
                indeg[child]--;
                if (indeg[child]==0) {
                    queue.add(child);
                }
            }
        }

        if (cnt!=V) {
            System.out.println("Cant schedule.");
        }else{
            System.out.println("Can schedule.");
        }
    }
}
