package stackandqueue._4_implementations;

import java.util.Arrays;
import java.util.Stack;

public class _2_stock_span_problem {
    static int[] pge(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];    
            while (!st.isEmpty() && arr[st.peek()]<=cur) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return  res;
    }
    public static void main(String[] args) {
        int arr[] = {7, 2, 1, 3, 3, 1, 8};
        //op:       [1, ,1, 1, 3, 4, 1, 7]
        // for each element need prev greater pos

        //1. FIND PGE
        int pge[] = pge(arr);

        int res[] = new int[arr.length];
        //2. Find POS FROM PGE
        for (int i = 0; i < res.length; i++) {
            res[i] = i - pge[i];
        }

        System.out.println(Arrays.toString(res));
    }
}
