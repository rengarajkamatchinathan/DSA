package stackandqueue._3_monotonic_stack;

import java.util.Stack;

public class _11_largest_rectangle {
    public static void main(String[] args) {
        int matrix[][] = {
            {1,0,1,0,0},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,0,0,1,0}
        };

        int maxi = -1;
        int heights[] = new int[matrix[0].length];
        for(int h[]:matrix){
            for (int i = 0; i < heights.length; i++) {
                if (h[i]==1) {
                    heights[i]++;
                }else{
                    heights[i] = 0;
                }
            }
            maxi = Math.max(maxi, helper(heights));
        }

        System.out.println(maxi);
    }

    static int helper(int heights[]){
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

        return maxi;
    }
}
