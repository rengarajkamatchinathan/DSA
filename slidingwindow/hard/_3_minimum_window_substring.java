
import java.util.HashMap;
import java.util.Map;

public class _3_minimum_window_substring {
    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        //doesnt need to in order/ can be any order
        //op: bca - 3
        Map<Character, Integer> hMap = new HashMap<>();
        for(char c:t.toCharArray()){
            hMap.put(c, 1);
        }

        int left = 0, right = 0, mini = (int)1e9;
        int cnt = 0;
        int sind = -1;

        while (right<s.length()) {
            if (hMap.containsKey(s.charAt(left)) && hMap.get(s.charAt(right))>0) {
                cnt++;
            }

            hMap.put(s.charAt(right), hMap.getOrDefault(s.charAt(right), 0) - 1 );
            
            while (cnt==t.length()) {
                if (mini>(right-left+1)) {
                    mini = (right-left+1);
                    sind = left;
                }
                hMap.put(s.charAt(left), hMap.get(s.charAt(left)) + 1 );
                if (hMap.get(s.charAt(left))>0) {
                    cnt--;
                }
                left++;
            }

            right++;
        }

        System.out.println(mini);
        System.out.println(s.substring(sind, sind+t.length()));
    }
}
