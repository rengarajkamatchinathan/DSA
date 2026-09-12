package binarytrees._3_hard;

import java.util.LinkedList;
import java.util.Queue;

class B{
    Node node;
    int ind;
    B(Node node, int ind){
        this.node = node;
        this.ind = ind;
    }
}
public class _3_maximum_width_bt {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(5);
        node.left.right = new Node(6);
        node.right.right = new Node(9);

        Queue<B> queue = new LinkedList<>();
        queue.add(new B(node, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int first=0, last = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node tmp_Node = queue.peek().node;
                int ind = queue.peek().ind;
                queue.poll();
                if(i==0) first = ind;
                if(i==size-1) last = ind;

                if(tmp_Node.left!=null){
                    queue.add(new B(tmp_Node.left, ind*2+1));
                }
                if(tmp_Node.right!=null){
                    queue.add(new B(tmp_Node.right, ind*2+2));
                }
            }

            maxWidth = Math.max(maxWidth, last-first+1);
        }

        System.out.println(maxWidth);
    }
}
