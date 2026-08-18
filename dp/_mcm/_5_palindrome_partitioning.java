package dp._mcm;

public class _5_palindrome_partitioning {
    static boolean isPal(int i, int j, String s){
        while (i<j) {
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }

    static int memo(int i, String str){
        if(i==str.length() || isPal(i, str.length()-1, str))return 0;

        int mini = Integer.MAX_VALUE;
        for(int k=i;k<str.length();k++){
            if (isPal(i, k, str)) {
                int cuts = 1 + memo(k+1, str);
                mini = Math.min(mini, cuts);
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        String str = "bababcbadcede";
        // Output: 4
        // Explanation: If we do 4 partitions in the following way, each substring of the partition will be a palindrome.
        // bab | abcba | d | c | ede.
        System.out.println(memo(0, str));
    }
}
