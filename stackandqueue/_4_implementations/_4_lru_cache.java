package stackandqueue._4_implementations;

import java.util.HashMap;
import java.util.Map;

class LRU_Cache{
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int cap;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> hmap;

    LRU_Cache(int cap){
        this.cap = cap;
        head.next = tail;
        tail.prev = head;
        hmap = new HashMap<>();
    }

    void put(int k, int v){
        if (hmap.containsKey(k)) {
            Node delNode = hmap.get(k);
            remove(delNode);
        }

        if (hmap.size()==cap) {
            hmap.remove(tail.prev.key);
            remove(tail.prev);
        }

        insert(new Node(k, v));
        hmap.put(k, head.next);
    }

    int get(int k){
        if (hmap.containsKey(k)) {
            Node delNode = hmap.get(k);
            remove(delNode);
            hmap.remove(k);
            
            insert(delNode);
            hmap.put(k, head.next);
            return head.next.val;
        }

        return -1;
    }

    void insert(Node newNode){
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    void remove(Node tmp){
        Node delNodePrev = tmp.prev;
        Node delNodeNext = tmp.next;
        delNodeNext.prev = delNodePrev;
        delNodePrev.next = delNodeNext;
    }
}
public class _4_lru_cache {
    public static void main(String[] args) {

    }
}
