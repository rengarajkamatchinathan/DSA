package binarytrees._3_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _6_min_time_to_burn_all_nodes {
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
    static void bfs(Node root, Node target){
        Set<Node> vis = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(target);
        vis.add(target);
        
        Map<Node, Node> parent = new HashMap<>();
        getParents(parent, root);

        int level = 0;

        while (!queue.isEmpty()) {
            for(Node node: queue){
                System.out.print(node.data);
            }
            System.out.println();
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
            level++;
        }
        System.out.println(level-1);
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        
        node.left.right = new Node(5);
        node.right.right = new Node(4);


        Node target = node.right.right;
        //op: 4

        bfs(node, target);
    }
}
