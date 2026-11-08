
import java.util.PriorityQueue;

public class _5_FindMedian_fromData_Stream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public _5_FindMedian_fromData_Stream() {
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>((a,b)->a-b);

    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        
    }
}
