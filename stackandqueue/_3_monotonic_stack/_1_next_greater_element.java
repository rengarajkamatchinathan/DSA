package stackandqueue._3_monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class _1_next_greater_element {
    public static void main(String[] args) {
        int arr[] = {5,7,1,7,6,0};
        // 7, -1, 7, -1, -1, -1

        int nge[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            //Monotonic Logic
            while (!stack.isEmpty() && stack.peek()<=arr[i]) {
                stack.pop();
            }

            //Logic for NGE[] array
            if (!stack.isEmpty() && stack.peek()>arr[i]) {
                nge[i] = stack.peek();
            }else{
                nge[i] = -1;
            }
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(nge));
    }
}
