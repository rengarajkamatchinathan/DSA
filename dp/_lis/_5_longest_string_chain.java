package dp._lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _5_longest_string_chain {
    static boolean isValid(String s1, String s2){
        if(s1.length()+1 != s2.length()) return false;
        //dog - dogs
        int i=0, j=0;

        while (i<s1.length()) {
            if (s1.charAt(i)==s2.charAt(j)) {
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        // System.out.println(s1+" "+s2);
        // System.out.println(i==s1.length() && j==s2.length()-1);
        return i==s1.length() && j==s2.length()-1;
    }
    public static void main(String[] args) {
        String words[] = {"dog", "dogs", "dots", "dot", "d", "do"};
        Arrays.sort(words);
        // Output:
        // 4 
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);
        int ans = -1;


        for(int ind=1;ind<words.length;ind++){
            for(int prev=0;prev<ind;prev++){
                if (isValid(words[prev],words[ind]) && dp[prev]+1>dp[ind]) {
                    System.out.println("is valid");
                    dp[ind] = dp[prev] + 1;

                    if(dp[ind]>ans){
                        ans = dp[ind];
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(ans);
    }
}
