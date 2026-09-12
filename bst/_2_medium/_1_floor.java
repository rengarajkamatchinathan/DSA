package bst._2_medium;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class _1_floor {
    static void floor(Node node, int x){
        Node cur = node;
        int ans = -1;

        while (cur!=null) {
            if (cur.data==x) {
                ans = cur.data;
                break;
            }
            if (cur.data>x) {
                cur = cur.left;
            }
            else{
                ans = cur.data;
                cur = cur.right;
            }
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        //FLOOR - val<=x
        Node node = new Node(10);
        node.left = new Node(5);
        node.left.left = new Node(2);
        node.left.right = new Node(8);
        node.left.right.left = new Node(6);
        node.right = new Node(15);
        node.right.left = new Node(13);
        node.right.right = new Node(17);

        floor(node, 4);
    }
}
