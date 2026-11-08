
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _5_Replace_elements_by_its_rank_in_the_array {
    public static void main(String[] args) {
        int arr[] = {20, 15, 26, 2, 98, 6};
        // Output: 4 3 5 1 6 2

        int tmp[] = new int[arr.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i];
        }
        Map<Integer, Integer> hMap = new HashMap<>();
        Arrays.sort(tmp);
        for (int i = 0; i < tmp.length; i++) {
            hMap.put(tmp[i], i);
        }

        System.out.println(hMap);

        List<Integer> res = new ArrayList<>();
        System.out.println(Arrays.toString(arr));
        for(int num:arr){
            res.add(hMap.get(num)+1);
        }
        System.out.println(res);
    }
}
