package binarytrees._2_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _6_zig_zag_traversal {
    static void soln(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        boolean lefttoright = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer level[] = new Integer[size];

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                int ind = lefttoright?i:size-i-1;
                level[ind] = node.data;

                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            lefttoright=!lefttoright;
            res.add(Arrays.asList(level));
        }

        System.out.println(res);
    }
    public static void main(String[] args) {
        // Create binary tree:
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6
        // [1] [3, 2] [4, 5, 6]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        soln(root);
    }
}
