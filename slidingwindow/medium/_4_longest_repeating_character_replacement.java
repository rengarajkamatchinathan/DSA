import java.util.Arrays;

public class _4_longest_repeating_character_replacement {
    public static void main(String[] args) {
        String s = "BAABAABBBAAA";
        int k = 2;  
        // Output: 6  

        int left = 0, right = 0, maxi = -1;
        //Prev maximum character cnt
        int maxCnt = 0;
        int freq[] = new int[26];

        while (right<s.length()) {
            freq[s.charAt(right)-'A']++;

            maxCnt = Math.max(maxCnt, freq[s.charAt(right)-'A']);

            while ((right-left+1)-maxCnt>k) {
                freq[s.charAt(left)-'A']--;
                left++;
            }

            maxi = Math.max(maxi, right-left+1);
            right++;
        }

        System.out.println(maxi);
    }
}
