package stackandqueue._3_monotonic_stack;

public class _5_rainwater_trapping {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        // Output : 6

        int left = 0, right = height.length-1;
        int maxLeft = 0, maxRight = 0;
        int sum = 0;

        while (left<=right) {
            if (height[left]<=height[right]) {
                if (maxLeft<height[left]) {
                    maxLeft = height[left];
                }else{
                    sum += maxLeft-height[left];
                }
                left++;
            }else{
                if (maxRight<height[right]) {
                    maxRight = height[right];
                }else{
                    sum += maxRight-height[right];
                }
                right--;
            }
        }

        System.out.println(sum);
    }
}
