package slidingwindow.medium;

import java.util.*;

public class _1_longest_substring_without_repiting_characters {
    public static void main(String[] args) {
        String S = "abcddabac";
        // Output:
        //  4
        int maxi = -1;
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while (r<S.length()) {
            //check whether r new char already in current window.
            //if already present in current window, then move L after that presenting character
            if (map.containsKey(S.charAt(r)) && map.get(S.charAt(r))>=l) {
                l = map.get(S.charAt(r)) + 1;
            }

            //Window logic
            maxi = Math.max(maxi, r-l+1);
            map.put(S.charAt(r), r);

            r++;
        }
        System.out.println(maxi);
    }
}