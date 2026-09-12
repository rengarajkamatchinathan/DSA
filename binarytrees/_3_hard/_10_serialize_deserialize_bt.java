package binarytrees._3_hard;

import java.util.LinkedList;
import java.util.Queue;

public class _10_serialize_deserialize_bt {
    static String serialize(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        StringBuilder str = new StringBuilder();

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (tmp==null) {
                str.append("#").append(",");
            }
            else{
                str.append(tmp.data).append(",");
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }

        return str.toString();
    }
    static void deserialize(String str){
        String vals[] = str.split(",");
        Node root = new Node(Integer.parseInt(vals[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i<vals.length) {
            Node tmp = queue.poll();

            if (!vals[i].equals("#")) {
                tmp.left = new Node(Integer.parseInt(vals[i]));
                queue.add(tmp.left);
            }
            i++;

            if (!vals[i].equals("#")) {
                tmp.right = new Node(Integer.parseInt(vals[i]));
                queue.add(tmp.right);
            }
            i++;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        String str = serialize(node);
        System.out.println(str);
    }
}
