package Algorithm;

/**
 * @author haiboWu
 * @create 2020-05-30 21:11
 */

import java.util.Arrays;

/**
 * 1. k <- [n/3]
 * 2. 将A中硬币分成X,Y,Z三个集合，使得|X|=|Y|=k,|Z|=n-2k
 * 3. if W(X) ≠ W(Y) //W(X), W(Y)分别为 X 或 Y 的重量
 * 4. then  A ← X ∪ Y
 * 5. else  A ← Z
 * 6. n ← |A| 算法 Coin(A, n)
 * 7. if n>2 then goto 1
 * 8. if n=2 then 任取 A 中1枚硬币与拿走硬币比较，若不等，则它不合格； 若相等，则 A 中剩下的硬币不合格.
 * 9. if n=1 then A 中硬币不合格
 */
public class No_05_GetCoins {
    public static void main(String[] args) {
        int nums[] = {3, 2, 2, 2, 2, 2, 2,2};
        System.out.println("the input array:" + Arrays.toString(nums));
        int count = getCounts(nums);
        System.out.println("total counts:"+count);
    }

    private static int getCounts(int[] nums) {
        if (nums.length <= 1) return 0;
        System.out.println("the different coins:" + getDiff(nums[0], nums));
        return count;
    }

    public static int count = 0;

    private static int getDiff(int flag, int[] nums) {
        count++;
        //如果数组只有一个，那就是这个
        if (nums.length == 1) return nums[0];
        //如果数组有两个，与另一个比较，相等则剩下的是，反之
        if (nums.length == 2) return nums[0] == flag ? nums[1] : nums[0];

        //将数组分成三个部分 k ，k，n-2k
        int k = nums.length / 3;
        int numA[] = Arrays.copyOfRange(nums, 0, k);
        int numB[] = Arrays.copyOfRange(nums, k, 2 * k);
        int numC[] = Arrays.copyOfRange(nums, 2 * k, nums.length);

        int sumA = ComputeSum(numA);
        int sumB = ComputeSum(numB);
        int sumC = ComputeSum(numC);

        //A==B 则 返回 C，A!=B则用  A+B重新判断
        return sumA == sumB ? getDiff(numA[0], numC) : getDiff(numC[0], Arrays.copyOfRange(nums, 0, 2 * k));
    }

    private static int ComputeSum(int[] numA) {
        int sum = 0;
        for (int i : numA) {
            sum += i;
        }
        return sum;
    }
}