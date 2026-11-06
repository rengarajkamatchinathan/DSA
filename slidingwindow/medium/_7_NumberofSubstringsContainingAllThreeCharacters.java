public class _7_NumberofSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abcba";
        //Output :  5
        // Explanation : The substrings containing at least one occurrence of the 
        // characters 'a' , 'b' , 'c' are "abc" , "abcb" , "abcba" , "bcba" , "cba".

        int left = 0, right = 0;
        int cnt = 0;
        int freq[] = new int[3];

        while (right<s.length()) {
            freq[s.charAt(right)-'a']++;

            while (freq[0]>0 && freq[1]>0 && freq[2]>0) {
                cnt += (s.length()-right);
                freq[s.charAt(left)-'a']--;
                left++;
            }

            right++;
        }

        System.out.println(cnt);
    }
}
