package binarytrees._3_hard;

public class _2_lca {
    static Node soln(Node node, int p, int q){
        if(node==null || node.data==p || node.data==q){
            return node;
        }

        Node left = soln(node.left, p, q);
        Node right = soln(node.right, p, q);

        if(node.left==null) return right;
        if(node.right==null) return left;

        //if both left and right gives , should be lowest ancestor. 
        //in future this will be moved to top by above condition left / right
        return node;
    }
    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(5);
        node.right = new Node(1);
        node.left.left = new Node(6);
        node.left.right = new Node(2);
        node.left.right.left = new Node(7);
        node.left.right.right = new Node(4);
/*
             3
            / \
           5   1
          / \
         6   2
            / \
           7   4
*/

        int p=5, q=1;
        //op:3
    }
}
