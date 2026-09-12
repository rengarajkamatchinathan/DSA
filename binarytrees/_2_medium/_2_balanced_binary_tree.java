package binarytrees._2_medium;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class _2_balanced_binary_tree {
    static int dfs(Node node){
        if(node==null) return 0;

        int leftHeight = dfs(node.left);
        if(leftHeight==-1)return -1;

        int rightHeight = dfs(node.right);
        if(rightHeight==-1)return -1;

        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        return Math.max(leftHeight, rightHeight)+1;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(2);
        node.left.left = new Node(5);
        node.left.right = new Node(4);
        // node.left.left.left = new Node(7);
        // node.left.left.right = new Node(6);

        System.out.println(dfs(node));
    }
}
