package binarytrees._3_hard;

public class _4_children_sum_property {
    static void soln(Node node){
        if(node==null) return;

        int child = 0;
        if(node.left!=null) child += node.left.data;
        if(node.right!=null) child += node.right.data;

        if (child>=node.data) {
            node.data = child;
        }else{
            if(node.left!=null) node.left.data = node.data;
            if(node.right!=null) node.right.data = node.data;
        }

        //go left and right and continue again like root node
        //treat left, right as individual node 
        soln(node.left);
        soln(node.right);

        int tot_after = 0;
        if(node.left!=null) tot_after += node.left.data;
        if(node.right!=null) tot_after += node.right.data;

        if (node.left!=null || node.right!=null) {
            node.data = tot_after;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        soln(root);
    }
}
