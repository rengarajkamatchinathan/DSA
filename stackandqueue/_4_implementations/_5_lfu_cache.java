package stackandqueue._4_implementations;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value, cnt;
    Node next;
    Node prev;
    
    Node(int _key, int _value) {
        key = _key;
        value = _value;
        cnt = 1;
    }
}
class List{
    int size;
    Node head, tail;
    List(){
        head.next = tail;
        tail.prev = head;
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
class LFU{
    int cap;
    int minFreq;
    Map<Integer, Node> hMap;
    Map<Integer, List> freqListMap;

    LFU(int cap){
        this.cap = cap;
        hMap = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    void put(int k, int v){
        if (hMap.containsKey(k)) {
            Node node = hMap.get(k);
            node.value = v;

            //update frequency map
            updateFrequency(node);
        }
        else{
            if (hMap.size()==cap) {
                List list = freqListMap.get(minFreq);
                //REMOVE FROM HASHMAP FIRST
                hMap.remove(list.tail.prev.key);
                //REMOVE FROM LRU List of FREQ LIST
                freqListMap.get(minFreq).remove(list.tail.prev);
            }

            minFreq = 1;
            List list = new List();
            if (freqListMap.containsKey(minFreq)) {
                list = freqListMap.get(minFreq);
            }

            Node node = new Node(k, v);
            list.insert(node);
            hMap.put(k, node);
            freqListMap.put(minFreq, list);
        }
    }

    int get(int k){
        if (hMap.containsKey(k)) {
            Node node = hMap.get(k);
            updateFrequency(node);
            return node.value;
        }

        return -1;
    }

    void updateFrequency(Node node){
        hMap.remove(node.key);
        freqListMap.get(node.cnt).remove(node);

        //IF THIS LRU LIST WAS MIN FREQ AND ALSO NO NODE LEFT
        if (minFreq==node.cnt && freqListMap.get(node.cnt).size==0) {
            minFreq++;
        }

        List nextFreqList = new List();
        if (freqListMap.containsKey(node.cnt+1)) {
            nextFreqList = freqListMap.get(node.cnt+1);
        }

        node.cnt += 1;

        nextFreqList.insert(node);
        freqListMap.put(node.cnt, nextFreqList);
        hMap.put(node.key, node);
    }
}
public class _5_lfu_cache {
    public static void main(String[] args) {
        
    }
}
