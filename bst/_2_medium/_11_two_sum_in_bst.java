package bst._2_medium;

import java.util.Stack;

class Iterator{
    Stack<Node> stack = new Stack<>();

    boolean reverse;
    Iterator(boolean reverse, Node root){
        this.reverse = reverse;
        pushAll(root);
    }

    int next(){
        Node tmp = stack.pop();
        if (!reverse) {
            pushAll(tmp.right);
        }else{
            pushAll(tmp.right);
        }
        return tmp.data;
    }

    void pushAll(Node node){
        while (node!=null) {
            stack.push(node);
            if (!reverse) {
                node = node.left;
            }else{
                node = node.right;
            }
        }
    }
}
public class _11_two_sum_in_bst {
    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);

        int k = 22;

        Iterator it = new Iterator(false, root);
        Iterator it_reversed = new Iterator(true, root);

        int i = it.next();
        int j = it_reversed.next();

        while (i<j) {
            if(i+j==k){
                System.out.println("FOUND : i ="+i +" & j = "+j);
                break;
            }
            else if(i+j<k){
                i = it.next();
            }else{
                j = it_reversed.next();
            }
        }
    }
}