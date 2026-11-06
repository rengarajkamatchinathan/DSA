package heap.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
public class _4_merge_m_sorted_list {
    static void soln(List<Node> inp){
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.data-b.data);
        for(Node node:inp){
            pq.add(node);
        }

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            res.add(tmp.data);
            if(tmp.next!=null){
                pq.add(tmp.next);
            }
        }

        System.out.println(res);
    }
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.next = new Node(2);
        root1.next.next = new Node(4);

        Node root2 = new Node(2);
        root2.next = new Node(5);

        Node root3 = new Node(10);

        List<Node> inp = new ArrayList<>();
        inp.add(root1);
        inp.add(root2);
        inp.add(root3);

        soln(inp);
    }
}
