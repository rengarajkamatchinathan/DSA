package bst._2_medium;

public class _6_check_if_bst {
    //in each root node maintain min and max range.
    //if node's >= max or <= min return false
    //also go to left(pass node as max) and right(node as min) 
    static boolean check(Node root, int min, int max){
        if (root==null) {
            return true;
        }

        if (root.data>=max || root.data<=min) {
            return false;
        }

        return check(root.left, min, root.data) && check(root.right, root.data, max);
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.left.right = new Node(2);
        root.right = new Node(4);

        System.out.println(check(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
