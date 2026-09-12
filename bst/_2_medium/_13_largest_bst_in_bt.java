package bst._2_medium;

class Pair{
    int size;
    int minNode;
    int maxNode;
    Pair(int size, int minNode, int maxNode){
        this.size = size;
        this.minNode = minNode;
        this.maxNode = maxNode;
    }
}
public class _13_largest_bst_in_bt {
    static Pair maxBST(Node root){
        if (root==null) {
            return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Pair left = maxBST(root.left);
        Pair right = maxBST(root.right);

        if (left.maxNode<root.data && root.data<right.minNode) {
            //we're telling it's parent. this subtree has this range 
            //Min - Max. So if the parent not in the range then problem/
            return new Pair(1 + left.size + right.size, 
                Math.min(root.data, left.minNode), 
                Math.max(root.data, right.maxNode));
        }

        return new Pair(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.left.left = new Node(1);
        node.left.right = new Node(8);
        node.right = new Node(15);
        node.right.right = new Node(7);
    }
}
