package bst._2_medium;

public class _3_insert_node_in_bst {
    static void insert(int x, Node root){
        Node cur = root;
        while (true) {
            if (cur.data>=x) {
                if(cur.left==null){
                    cur.left = new Node(x);
                    break;
                }
                else{
                    cur = cur.left;
                }
            }
            else{
                if (cur.right==null) {
                    cur.right = new Node(x);
                    break;
                }
                else{
                    cur = cur.right;
                }
            }
        }
    }
    public static void main(String[] args) {
        Node node = new Node(6);
        node.left = new Node(3);
        node.left.left = new Node(2);
        node.left.right = new Node(4);

        node.right = new Node(8);
        node.right.left = new Node(7);

        int ins = 5;
    }
}
