package bst._2_medium;

public class _9_successer_predecesser {
    static void successer_inorder(Node root, Node tar){
        Node successer = null;
        while (root!=null) {
            if (root.data<=tar.data) {
                root = root.right;
            }else{
                successer = root;
                root = root.left;
            }
        }
        if (successer!=null) {
            System.out.println(successer.data);
        }else{
            System.out.println("successer not found");
        }
    }
    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(8);
        node.left.left = new Node(7);
        node.left.right = new Node(10);
        node.left.right.left = new Node(9);
        node.left.right.right = new Node(12);

        Node tar = node.left;
        successer_inorder(node, tar);
    }
}
