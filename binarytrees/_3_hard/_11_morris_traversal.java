package binarytrees._3_hard;

import java.util.ArrayList;
import java.util.List;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class _11_morris_traversal {
    static void preorder(Node root){
        Node cur = root;
        List<Integer> res = new ArrayList<>();

        while (cur!=null) {
            if (cur.left==null) {
                res.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while (prev.right!=null && prev.right!=cur) {
                    prev = prev.right;
                }
                //connect prev's right end to current
                if (prev.right==null) {
                    prev.right = cur;
                    res.add(cur.data);
                    cur = cur.left;
                }
                //already connected
                else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }

        System.out.println(res);
    }

    static void inorder(Node root){
        Node cur = root;
        List<Integer> res = new ArrayList<>();

        while (cur!=null) {
            if (cur.left==null) {
                res.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while (prev.right!=null && prev.right!=cur) {
                    prev = prev.right;
                }
                //connect prev's right end to current
                if (prev.right==null) {
                    prev.right = cur;
                    cur = cur.left;
                }
                //already connected
                else{
                    prev.right = null;
                    res.add(cur.data);
                    cur = cur.right;
                }
            }
        }

        System.out.println(res);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        preorder(root);
        inorder(root);
    }
}
