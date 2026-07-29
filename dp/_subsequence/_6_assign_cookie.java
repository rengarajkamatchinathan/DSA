package dp._subsequence;

import java.util.Arrays;

public class _6_assign_cookie {
    static int memo(int s, int c, int student[], int cookie[], int dp[][]){
        if (s>=student.length || c>=cookie.length) {
            return 0;
        }

        if (dp[s][c]!=-1) {
            return dp[s][c];
        }

        int res = 0;
        if (cookie[c]>=student[s]) {
            res = 1 + memo(s+1, c+1, student, cookie, dp);
        }

        res = Math.max(
            res,
            memo(s, c+1, student, cookie, dp)
        );

        return dp[s][c] = res;
    }

    static int tab(int student[], int cookie[]){
        int n = student.length;
        int m = cookie.length;
        int dp[][] = new int[n+1][m+1];

        for(int s=n-1;s>=0;s--){
            for(int c=m-1;c>=0;c--){
                int res = 0;
                if (cookie[c]>=student[s]) {
                    res = 1 + dp[s+1][c+1];
                }

                res = Math.max(
                    res,
                    dp[s][c+1]
                );

                dp[s][c] = res;
            }
        }

        for(int a[]:dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int Student[] = {1, 2};
        int Cookie[] = {1, 2, 3};
        // Output : 2
        // Explanation : Cookie 1 satisfies student 1 and cookie 2 satisfies student 2. Therefore, 2 students are content.

        int dp[][] = new int[Student.length+1][Cookie.length+1];
        for(int d[]:dp){
            Arrays.fill(d, -1);
        }
        System.out.println(memo(0, 0, Student, Cookie, dp));
        System.out.println(tab(Student, Cookie));
    }
}
