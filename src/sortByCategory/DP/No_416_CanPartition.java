package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-05-28 17:06
 */
public class No_416_CanPartition {
    public static void main(String[] args) {
        int nums[]={1,5,11,5};
        getCanpartition(nums);
    }

    private static boolean getCanpartition(int[] nums) {
        int sum=computeSum(nums);
        if(sum%2!=0){
            return false;
        }
        return true;
    }

    private static int computeSum(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        return sum;
    }
}
