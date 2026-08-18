package dp._mcm;

public class _6_partition_arr_for_max_sum {
    static int memo(int i,int k, int arr[]){
        if(i==arr.length) return 0;

        int sum = 0;
        int maxElem = 0;

        //iterate length and pass into next recursion
        for(int length = 1; length<=k && i+length<=arr.length; length++){
            maxElem = Math.max(maxElem, arr[i+length-1]);
             
            //current sum + next partition
            int currentsum = maxElem*length + memo(i+length, k, arr);

            sum = Math.max(sum, currentsum);
        }

        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {1,15,7,9,2,5,10};
        int k = 3;
        // Output: 84
        //15,15,15,9,10,10,10

        System.out.println(memo(0, k, arr));
    }    
}