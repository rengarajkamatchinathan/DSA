package binarytrees._2_medium;

public class _5_check_if_identical_tree {
    static boolean check(Node node1, Node node2){
        if (node1==null && node2==null) return true;
        if(node1==null || node2==null) return false;

        return node1.data==node2.data 
        && check(node1.left, node2.left) 
        && check(node1.right, node2.right);
    }
    public static void main(String[] args) {
        // Creating the first binary tree (Node1)
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Creating the second binary tree (Node2)
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
    }
}
