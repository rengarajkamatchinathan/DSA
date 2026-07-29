package dp._stocks;

public class _1_best_time_to_buy_sell_I {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        //Output: 5
        int mini = prices[0];
        int ans = -1;

        for (int i = 1; i < prices.length; i++) {
            mini = Math.min(mini, prices[i]);
            ans = Math.max(ans, prices[i]-mini);
        }

        System.out.println(ans);
    }
}
