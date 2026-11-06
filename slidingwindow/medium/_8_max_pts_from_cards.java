public class _8_max_pts_from_cards {
    public static void main(String[] args) {
        int[] cardScore = {5, 4, 1, 8, 7, 1, 3};
        int k = 3;
        int n = cardScore.length;
        //You can choose first k cards / last k / first some and last some atmost k
        // Output : 15
        // Explanation :Choosing the rightmost cards will maximize your total score. 
        // So optimal cards chosen are the rightmost three cards 4 , 5 , 6.
        // Th score is 4 + 5 + 6 => 15.

        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardScore[i];
        }
        int maxi = total;

        for (int i = 0; i < k; i++) {
            total -= cardScore[k-i-1];
            total += cardScore[n-i-1];
            maxi = Math.max(maxi, total);
        }
        System.out.println(maxi);
    }
}
