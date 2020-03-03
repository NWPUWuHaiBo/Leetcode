package sortByCategory.Greedy;

/**
 * @author haiboWu
 * @create 2020-03-03 23:28
 */
public class No_605_4CanPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int pre;
        int next;
        for (int i = 0; i < flowerbed.length; i++) {
            pre = i == 0 ? 0 : flowerbed[i - 1];
            next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (flowerbed[i] == 1) continue;
            if (flowerbed[i] == 0) {
                if (pre == 0 && next == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
}
