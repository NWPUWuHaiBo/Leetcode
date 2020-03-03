package sortByCategory.Greedy;

/**
 * @author haiboWu
 * @create 2020-03-03 23:00
 */
public class No_122_BestBuyAndSell2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                max+=(prices[i]-prices[i-1]);
            }
        }
        return max;
    }
}
