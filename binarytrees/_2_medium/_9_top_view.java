package binarytrees._2_medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class P{
    Node node;
    int x;
    P(Node node, int x){
        this.node = node;
        this.x = x;
    }
}
public class _9_top_view {
    static void soln(Node root){
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<P> queue = new LinkedList<>();
        queue.add(new P(root, 0));

        while (!queue.isEmpty()) {
            Node node = queue.peek().node;
            int x = queue.peek().x;
            queue.poll();

            if (map.get(x)==null) {
                map.put(x, node.data);
            }

            if(node.left!=null) queue.add(new P(node.left, x-1));
            if(node.right!=null) queue.add(new P(node.right, x+1));
        }

        List<Integer> res = new ArrayList<>();
        for(int node:map.values()){
            res.add(node);
        }
        System.out.println(res);
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
