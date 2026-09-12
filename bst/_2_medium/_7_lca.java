package bst._2_medium;

public class _7_lca {
    static Node lca(Node root, Node p, Node q){
        if (root==null) {
            return null;
        }
        if (root.data<p.data && root.data<q.data) {
            return lca(root.right, p, q);
        }
        if (root.data>p.data && root.data>q.data) {
            return lca(root.left, p, q);
        }
        return root;
    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.left.left = new Node(2);
        node.left.right = new Node(8);
        node.left.right.left = new Node(6);
        node.right = new Node(15);
        node.right.left = new Node(13);
        node.right.right = new Node(17);

        Node p = node.left.left;
        Node q = node.left.right.left;
    }
}
