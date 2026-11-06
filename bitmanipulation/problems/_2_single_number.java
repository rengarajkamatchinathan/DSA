package bitmanipulation.problems;

public class _2_single_number {
    public static void main(String[] args) {
        int nums[] = {1,1,2,2,3,4,4};
        //op; 3

        int xor = 0;
        for(int num:nums){
            xor = xor ^ num;
        }

        System.out.println(xor);
    }
}
