package bst._2_medium;

public class _5_kth_smallest_largest {
    static int res = -1;
    static int k = 0;

    static void inorder(Node node){
        if (node!=null) {
            inorder(node.left);
            if (--k==0) {
                res=node.data;
                return;
            }
            inorder(node.right);
        }
    }
    
    static void reverseInorder(Node node){
        if (node!=null) {
            inorder(node.right);
            if (--k==0) {
                res=node.data;
                return;
            }
            inorder(node.left);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.left.right = new Node(2);
        root.right = new Node(4);

        int c = 1;
        k=c;
        inorder(root);
        System.out.println(res);
        k=c;
        reverseInorder(root);
        System.out.println(res);
    }
}
