package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-03-22 15:32
 */
public class No_303_RangeSumQuery {
    private   int []res;
    public No_303_RangeSumQuery(int[] nums) {
        res=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            res[i+1]=res[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return res[j+1]-res[i];
    }
}
