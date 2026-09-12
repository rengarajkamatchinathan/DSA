package stackandqueue._3_monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class _2_next_greater_element_II {
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        // [2, -1, 2]
        // technically array be like 1,2,1,1,2,1;

        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            int idx = i%n;

            while (!stack.isEmpty() && stack.peek()<=arr[idx]) {
                stack.pop();
            }

            if (i<n) {
                nge[idx] = !stack.isEmpty()?stack.peek():-1;
            }
            stack.push(arr[idx]);
        }

        System.out.println(Arrays.toString(nge));
    }
}
