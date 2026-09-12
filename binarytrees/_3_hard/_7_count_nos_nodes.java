package binarytrees._3_hard;

public class _7_count_nos_nodes {
    static int soln(Node node){
        if(node==null) return 0;

        int lh = leftHeight(node);
        int rh = rightHeight(node);

        if (lh==rh) {
            return (1<<lh) - 1;
        }

        return 1 + soln(node.left) + soln(node.right);
    }

    static int leftHeight(Node node){
        int height = 0;
        while (node!=null) {
            height++;
            node = node.left;
        }
        return height;
    }
    static int rightHeight(Node node){
        int height = 0;
        while (node!=null) {
            height++;
            node = node.right;
        }
        return height;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);

        System.out.println(soln(node));
    }
}
