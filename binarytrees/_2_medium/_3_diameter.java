package binarytrees._2_medium;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class _3_diameter {
    static int height(Node node, int diameter[]){
        if(node==null) return 0;

        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(2);
        node.left.left = new Node(5);
        node.left.right = new Node(4);
        node.left.left.left = new Node(7);
        node.left.left.right = new Node(6);

        int diameter[] = new int[1];
        height(node, diameter);
        System.out.println(diameter[0]);
    }
}
