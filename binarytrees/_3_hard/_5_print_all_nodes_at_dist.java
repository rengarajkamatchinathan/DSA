package binarytrees._3_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _5_print_all_nodes_at_dist {
    static void getParents(Map<Node, Node> parent, Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            if (tmp.left!=null) {
                parent.put(tmp.left, tmp);
                queue.add(tmp.left);
            }
            if (tmp.right!=null) {
                parent.put(tmp.right, tmp);
                queue.add(tmp.right);
            }
        }
    }
    static void bfs(Node root, Node target, int k){
        Set<Node> vis = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(target);
        vis.add(target);
        
        Map<Node, Node> parent = new HashMap<>();
        getParents(parent, root);

        int level = 0;

        while (!queue.isEmpty()) {
            if (level++==k) {
                break;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left!=null && !vis.contains(node.left)){
                    queue.add(node.left);
                    vis.add(node.left);
                }
                if(node.right!=null && !vis.contains(node.right)){
                    queue.add(node.right);
                    vis.add(node.right);
                }
                if(parent.containsKey(node) && !vis.contains(parent.get(node))){
                    queue.add(parent.get(node));
                    vis.add(parent.get(node));
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(Node node:queue){
            res.add(node.data);
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(5);
        node.right = new Node(1);
        node.left.left = new Node(6);
        node.left.right = new Node(2);
        node.left.right.left = new Node(7);
        node.left.right.right = new Node(4);
        node.right.left = new Node(0);
        node.right.right = new Node(8);
        //Output:
        // [7,4,1]

        Node target = node.left;
        int k = 2;

        bfs(node, target, k);
    }
}
