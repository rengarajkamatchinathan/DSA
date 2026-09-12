package binarytrees._1_traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}
public class _3_iterative {
    static void preorder(Node root){
        //Root Left Right
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.data);
            if (node.right!=null) stack.add(node.right);
            if (node.left!=null) stack.add(node.left);
        }
        System.out.println(res);
    }

    static void inord(Node root){
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        
        while (true) {
            if (node!=null) {
                stack.add(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()) break;

                Node tmp = stack.pop();
                res.add(tmp.data);

                node = tmp.right;
            }
        }

        System.out.println(res);
    }

    static void postord(Node root){
        //Little tweak from Preorder to get
        //Root->Right->Left
        Stack<Node> stack1 = new Stack<>();
        stack1.add(root);

        //FOR reversing Preorder
        //Left->Right->Root
        Stack<Node> stack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            Node tmp = stack1.pop();
            stack2.add(tmp);

            if(tmp.left!=null)stack1.add(tmp.left);
            if(tmp.right!=null)stack1.add(tmp.right);
        }

        List<Integer> res = new ArrayList<>();
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().data);
        }
    }

    static void postord_1stack(Node root){
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node lastVis = null;
        List<Integer> res = new ArrayList<>();

        while (node!=null || !stack.isEmpty()) {
            //go left as possible
            if(node!=null){
                stack.add(node);
                node = node.left;
            }
            else{
                Node peek = stack.peek();
                if (peek.right!=null || peek.right!=lastVis) {
                    node = peek.right;
                }
                else{
                    res.add(peek.data);
                    lastVis = stack.pop();
                }
            }
        }
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
    }
}
