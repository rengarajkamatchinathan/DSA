package binarytrees._2_medium;

public class _12_symmety_bts {
    static boolean check(Node node1, Node node2){
        if(node1==null || node2==null){
            return node1==node2;
        }

        return node1.data == node2.data 
        &&check(node1.left, node2.right)
        &&check(node1.right, node2.left);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
    }
}
