import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SafeStates {
    public static void main(String[] args) {
        int graph[][]={{1},{2},{0,3},{}};
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            revAdj.add(new ArrayList<>());
        }
        int ind[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        //1.Construct reverse adj list
        //Because reversing edges results the safe nodes ie, u has no v
        //2.find indegree's
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                revAdj.get(graph[i][j]).add(i);
                ind[i]++;
            }
        }
        //3.topo
    }
}
