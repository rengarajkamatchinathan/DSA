package binarytrees._1_traversals;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}
public class _1_recursive {
    static void preord(Node node){
        if(node==null)return;

        System.out.print(node.data+" ");
        preord(node.left);
        preord(node.right);
    }

    static void inord(Node node){
        if(node==null)return;

        inord(node.left);
        System.out.print(node.data+" ");
        inord(node.right);
    }

    static void posord(Node node){
        if(node==null)return;

        posord(node.left);
        posord(node.right);
        System.out.print(node.data+" ");
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preord(root);
        System.out.println();
        inord(root);
        System.out.println();
        posord(root);
    }
}
