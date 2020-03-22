package sortByCategory.DP;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-21 16:32
 */
public class No_213_HouseRober2 {
    @Test
    public void Test(){
        int nums[]={2,3,2};
        System.out.println(rob(nums));
    }
    public int rob(int[] nums) {
       if(nums==null||nums.length==0){
           return 0;
       }
       if(nums.length==1){
           return nums[0];
       }
       return Math.max(getMax(nums,0,nums.length-1),getMax(nums,1,nums.length));
    }

    private int getMax(int[] nums, int start, int end) {
        int pre2=0,pre1=0;
        for (int i = start; i < end; i++) {
            int cur=Math.max(pre1,pre2+nums[i]);
            pre2=pre1;
            pre1=cur;
        }
        return pre1;
    }
}
