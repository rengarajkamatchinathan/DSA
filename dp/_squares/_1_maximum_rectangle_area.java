package dp._squares;

import java.util.Stack;

public class _1_maximum_rectangle_area {
    static int soln(int matrix[][]){
        int heights[] = new int[matrix[0].length];
        int maxi = Integer.MIN_VALUE;

        for(int m[]:matrix){
            for(int t=0;t<m.length;t++){
                if(m[t]==1)heights[t]++;
                else heights[t] = 0;
            }
            
            //find rectangle
            maxi = Math.max(maxi, helper(heights));
        }
        return maxi;
    }

    static int helper(int arr[]){
        Stack<Integer> stack = new Stack<>();
        //1 2 3 2 1
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length; i++) {
            int current_height = i==arr.length?0:arr[i];

            while (!stack.isEmpty() && current_height<arr[stack.peek()]) {
                int height = arr[stack.pop()];
                //what if 3 4 5 2. Here for 2 stack becomes empty. 
                // So height is being all heights of prev right?
                int width = stack.isEmpty()?i:i - stack.peek() - 1;

                maxi = Math.max(maxi, height*width);
            }
            stack.push(i);
        }

        return maxi;
    }
    public static void main(String[] args) {
         int matrix[][] = {
            {1,0,1,0,0},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,0,0,1,0}};

            System.out.println(soln(matrix));
    }
}
