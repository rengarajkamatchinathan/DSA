
import java.util.ArrayList;
import java.util.List;

public class _8_LRU {
    public static void main(String[] args) {
        int[] pages = {1, 2, 3, 1, 4, 5};
        int capacity = 3;

        // Process them one by one:
        // Page	Frames	Result
        // 1	[1]	Fault
        // 2	[1, 2]	Fault
        // 3	[1, 2, 3]	Fault
        // 1	[1, 2, 3]	Hit
        // 4	[1, 4, 3]	Fault → remove 2
        // 5	[1, 4, 5]	Fault → remove 3

        int pageFault = 0;
        List<Integer> frames = new ArrayList<>();

        for(int page:pages){
            if (frames.contains(page)) {
                frames.remove(frames.indexOf(page));
                frames.add(page);
                System.out.println(page + " -> " + frames);
            }
            else{
                pageFault++;
                if (frames.size()==capacity) {
                    frames.remove(0);
                }
                frames.add(page);
                System.out.println(page + " -> " + frames);
            }
        }

        System.out.println(pageFault);
    }
}
