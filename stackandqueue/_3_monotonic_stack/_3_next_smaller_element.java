package stackandqueue._3_monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class _3_next_smaller_element {
    public static void main(String[] args) {
        int arr[] = {4, 8, 5, 2, 25};
        //  [2, 5, 2, -1, -1]

        int nse[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            //Monotonic Logic
            while (!stack.isEmpty() && stack.peek()>=arr[i]) {
                stack.pop();
            }

            //Logic for nse[] array
            if (!stack.isEmpty() && stack.peek()<arr[i]) {
                nse[i] = stack.peek();
            }else{
                nse[i] = -1;
            }
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(nse));
    }
}
