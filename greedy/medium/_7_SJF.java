
import java.util.Arrays;

//Shortest job first
public class _7_SJF {
    public static void main(String[] args) {
        int arr[] = {4,3,7,1,2};
        //op =  4

        int t = 0;
        int wt = 0;

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            wt += t;
            t += arr[i];
        }

        System.out.println(wt/arr.length);
    }
}
