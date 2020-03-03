package sortByCategory.Greedy;

/**
 * @author haiboWu
 * @create 2020-03-03 23:00
 */
public class No_121_BestBuyAndSell {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (soFarMin > prices[i]) soFarMin = prices[i];
            else {
                max=Math.max(max,prices[i]-soFarMin);
            }
        }
        return max;
    }
}
