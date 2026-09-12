package binarytrees._2_medium;

import java.util.ArrayList;
import java.util.List;

public class _11_leftOrRight_view {
    static void leftView(Node node, int level, List<Integer> res){
        if(res.size()==level){
            res.add(node.data);
        }
        if(node.left!=null){
            leftView(node.left, level+1, res);
        }
        if(node.right!=null){
            leftView(node.right, level+1, res);
        }
    }

    static void rightView(Node node, int level, List<Integer> res){
        if(res.size()==level){
            res.add(node.data);
        }
        if(node.right!=null){
            leftView(node.right, level+1, res);
        }
        if(node.left!=null){
            leftView(node.left, level+1, res);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        List<Integer> res = new ArrayList<>();

        leftView(root, 0, res);
        System.out.println(res);
    }
}
