package stackandqueue._3_monotonic_stack;

import java.util.Stack;

public class _7_asteroid_collision {
    public static void main(String[] args) {
        int arr[] = {5,10,-5};
        // [5, 10]
        //arr[] = {8,-8}
        //[]

        Stack<Integer> st = new Stack<>();
        for(int it:arr){
            if (it>=0) {
                st.push(it);
            }else{
                while (!st.isEmpty() && st.peek()<=Math.abs(it)) {
                    st.pop();
                }

                //EDGE CASE
                if (st.isEmpty() || st.peek()<0) {
                    st.push(it);
                }
            }
        }
    }
}
