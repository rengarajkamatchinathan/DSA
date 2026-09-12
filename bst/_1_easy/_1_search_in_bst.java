package bst._1_easy;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class _1_search_in_bst {
    static Node search(Node node, int x){
        while (node!=null && node.data!=x) {
            if (node.data>x) {
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        return node;
    }
    public static void main(String[] args) {
        Node node = new Node(8);
        node.left = new Node(5);
        node.left.left = new Node(4);
        node.left.right = new Node(7);
        node.right = new Node(12);
        node.right.left = new Node(10);
        node.right.right = new Node(14);

        int k = 10;

        //op:true
        Node tmp = search(node, k);
        if (tmp==null) {
            System.out.println("false");
        }else{
            System.out.println("true");
        }
    }
}
