import java.util.Map;

public class _3_fruits_into_basket {
    static void withHashMap(int fruits[], int k){
        Map<Integer, Integer> hMap = new HashMap<>();
        int l=0, r=0, maxi = -1;

        while (r<fruits.length) {
            hMap.put(fruits[r], hMap.getOrDefault(fruits[r], 1));
            while (hMap.size()>k) {
                hMap.put(fruits[l], hMap.get(fruits[l])-1);
                if (hMap.get(fruits[l])==0) {
                    hMap.remove(fruits[left]);
                }
                l++;
            }

            maxi = Math.max(maxi, r-l+1);
            r++;
        }
        System.out.println(maxi);
    }
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        // Output : 4
        withHashMap(fruits, 2);
    }    
}