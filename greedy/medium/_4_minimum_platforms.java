
import java.util.Arrays;

public class _4_minimum_platforms {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        // Output: 3
        // Explanation:
        // Minimum 3 platforms are required to safely arrive and depart all trains.
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int cnt = 0, maxi = 0;

        while (i<arr.length) {
            if (arr[i]<=dep[j]) {
                cnt++;
                maxi = Math.max(maxi, cnt);
                i++;        
            }else{
                cnt--;
                j++;
            }
        }
    }
}
