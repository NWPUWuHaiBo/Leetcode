package sortByCategory.DoublePointer;

/**
 * @author haiboWu
 * @create 2020-02-28 15:06
 */
//题目描述：判断一个数是否为两个数的平方和
public class No_633_SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
