package binarytrees._2_medium;

import java.util.ArrayList;
import java.util.List;

public class _7_boundary_traverse {
    static boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }
    static void addLeftBoundary(Node node, List<Integer> res){
        if(node==null)return;

        if(!isLeaf(node)){
            res.add(node.data);
        }
        if (node.left!=null) {
            addLeftBoundary(node.left, res);
        }else{
            addLeftBoundary(node.right, res);
        }
    }

    static void addRightBoundary(Node node, List<Integer> res){
        if(node==null)return;

        if(!isLeaf(node)){
            res.add(node.data);
        }
        if (node.right!=null) {
            addLeftBoundary(node.right, res);
        }else{
            addLeftBoundary(node.left, res);
        }
    }

    static void addLeaves(Node node, List<Integer> res){
        if(node==null)return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        if (node.left!=null) {
            addLeaves(node.left, res);
        }
        if (node.right!=null) {
            addLeaves(node.right, res);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> res = new ArrayList<>();
        res.add(root.data);

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);

        System.out.println(res);
    }
}
