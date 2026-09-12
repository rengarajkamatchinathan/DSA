package binarytrees._2_medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
    Node node;
    int x;
    int y;
    Pair(Node node, int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
public class _8_vertical_traverse {
    static void soln(Node root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node node = p.node;
            int x = p.x;
            int y = p.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).add(node.data);

            if (node.left!=null) {
                queue.add(new Pair(node.left, x-1, y+1));
            }
            if (node.right!=null) {
                queue.add(new Pair(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> t: map.values()){
            List<Integer> row = new ArrayList<>();
            for(PriorityQueue<Integer> pq : t.values()){
                while (!pq.isEmpty()) {
                    row.add(pq.poll());
                }
            }
            ans.add(row);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        soln(root);
    }
}
