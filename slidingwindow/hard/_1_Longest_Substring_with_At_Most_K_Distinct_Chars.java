package slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class _1_Longest_Substring_with_At_Most_K_Distinct_Chars {
    public static void main(String[] args) {
        String s = "abcddefg";
        int k = 3;
        // Output : 4
        // Explanation : The longest substring with at most three distinct characters is "bcdd".
        // The length of the string 4.
        Map<Character, Integer> hMap = new HashMap<>();
        int left = 0, right = 0;
        int maxi = 0;

        while (right<s.length()) {
            hMap.put(s.charAt(right), hMap.getOrDefault(s.charAt(right), 0)+1);

            while (hMap.size()>k) {
                hMap.put(s.charAt(left), hMap.get(s.charAt(left))-1);
                if (hMap.get(s.charAt(left))==0) {
                    hMap.remove(s.charAt(left));
                }
                left++;
            }

            maxi = Math.max(maxi, right-left+1);
            right++;
        }

        System.out.println(maxi);
    }    
}