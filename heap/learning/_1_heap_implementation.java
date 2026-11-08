
import java.util.ArrayList;
import java.util.List;

class Heap{
    List<Integer> heap;
    Heap(){
        heap = new ArrayList<>();
    }

    void insert(int num){
        heap.add(num);
        upheap(heap.size()-1);
    }
    void upheap(int i){
        if(i==0) return ;

        int p = parent(i);

        if (heap.get(p)<heap.get(i)) {
            swap(i, p);
            upheap(p);
        }
    }

    void remove(){
        int val = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.removeLast();
        downHeap(0);
    }

    void downHeap(int i){
        int min = i;
        int left = left(i);
        int right = right(i);

        if(heap.get(min) < heap.get(left)){
            min = left;
        }
        
        if (heap.get(min) < heap.get(right)) {
            min = right;
        }

        if(min!=i){
            swap(min, i);
            downHeap(min);
        }
    }

    int parent(int i){
        return (i-1)/2;
    }

    int left(int i){
        return (2*i)+1;
    }

    int right(int i){
        return (2*i)+2;
    }

    void swap(int u, int v){
        int t = heap.get(u);
        heap.set(u, heap.get(v));
        heap.set(v, t);
    }
}
public class _1_heap_implementation {
    public static void main(String[] args) {
        
    }
}
