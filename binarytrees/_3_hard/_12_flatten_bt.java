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
public class _12_flatten_bt {
    static void flat(Node root){
        Node cur = root;
        while (cur!=null) {
            if (cur.left!=null) {
                Node prev = cur.left;
                while (prev.right!=null) {
                    prev = prev.right;
                }
                
                //connect right end of prev to curr->right
                prev.right = cur.right;
                //connect new right of curr is prev/cur->left
                cur.right = cur.left;

                cur.left = null;
            }
            cur = cur.right;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        flat(root);

        List<Integer> res = new ArrayList<>();
        while (root!=null) {
            res.add(root.data);
            root = root.right;
        }

        System.out.println(res);
    }
}
