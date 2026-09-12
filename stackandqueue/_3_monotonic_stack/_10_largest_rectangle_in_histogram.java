package stackandqueue._3_monotonic_stack;

import java.util.Stack;

public class _10_largest_rectangle_in_histogram {
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        //op = 10

        int maxi = -1;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<=heights.length;i++){
            int currHeight = i==heights.length?0:heights[i];

            while (!st.isEmpty() && currHeight<heights[st.peek()]) {
                int h = heights[st.pop()];
                int w = st.isEmpty()? i : i-st.peek()-1;
                maxi = Math.max(maxi, w*h);
            }
            
            st.push(i);
        }

        System.out.println(maxi);
    }
}
