package bst._2_medium;

public class _4_delete {
    static void delete(Node root, int x){
        if (root.data==x) {
            helper(root);
            return;
        }
        Node cur = root;

        while (true) {
            if (cur.data>x) {
                if (cur.left!=null && cur.left.data==x) {
                    cur.left = helper(cur.left);
                    break;
                }
                else{
                    cur = cur.left;
                }
            }else{
                if (cur.right!=null && cur.right.data==x) {
                    cur.right = helper(cur.right);
                    break;
                }else{
                    cur = cur.right;
                }
            }
        }
    }

    static Node helper(Node root){
        if (root.left==null) {
            return root.right;
        }else if(root.right==null){
            return root.left;
        }else{
            Node tmp = root.left;
            root.left = root.right;
            
            //go to extreme left of current left and connect it to tmp
            Node leftEnd = root.left;
            while (leftEnd.left!=null) {
                leftEnd = leftEnd.left;
            }
            leftEnd.left = tmp;

            return root.left;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.left.left = new Node(2);
        node.left.right = new Node(6);
        node.right = new Node(11);

        int del = 6;

        //    10
        //   /  \
        //  6    11 
        // / \
        // 2  5
        //   / \
        //  4   7
        delete(node, del);
    }
}
