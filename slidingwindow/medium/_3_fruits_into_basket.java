import java.util.HashMap;
import java.util.Map;

public class _3_fruits_into_basket {
    static void withHashMap(int fruits[], int k){
        Map<Integer, Integer> hMap = new HashMap<>();
        int l=0, r=0, maxi = -1;

        while (r<fruits.length) {
            hMap.put(fruits[r], hMap.getOrDefault(fruits[r], 0)+1);

            while (hMap.size()>k) {
                hMap.put(fruits[l], hMap.get(fruits[l])-1);
                if (hMap.get(fruits[l])==0) {
                    hMap.remove(fruits[l]);
                }
                l++;
            }

            maxi = Math.max(maxi, r-l+1);
            r++;
        }
        System.out.println(maxi);
    }
    static void optimal(int fruits[]){
        int lastFruit = -1, secondLastFruit = -1;
        int currCnt = 0, lastFruitStreak = 0;
        int maxlen = 0;

        for(int fruit:fruits){
            if (fruit==lastFruit || fruit==secondLastFruit) {
                currCnt++;
            }
            else{
                currCnt = lastFruitStreak + 1;
            }

            maxlen = Math.max(maxlen, currCnt);
        }
    }
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        // Output : 4
        withHashMap(fruits, 2);
    }    
}