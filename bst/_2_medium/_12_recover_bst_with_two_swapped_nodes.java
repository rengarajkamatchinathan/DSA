package bst._2_medium;

public class _12_recover_bst_with_two_swapped_nodes {
    static Node prev;
    static Node first;
    static Node mid;
    static Node last;
    
    static void inorder(Node root){
        if (root==null) {
            return;
        }

        inorder(root.left);
        if (prev!=null && prev.data>root.data) {
            //If its first violation, mark these nodes as first and middle
            if (first==null) {
                first = prev;
                mid = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    public static void main(String[] args) {
        inorder(first);

        if (first!=null && last!=null) {
            //swap their values
        }else if (first!=null && mid!=null) {   
            //swap their vals
        }
    }
}