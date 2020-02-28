package sortByOrder.part5;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-02-17 19:30
 */
public class No_41 {
    @Test
    public void TestFirstMissingPositive(){
        int nums[]={1, 1};
        System.out.println(firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (isVaild(i,nums)&&(nums[nums[i]-1]!=nums[i])) {
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public boolean isVaild(int i, int nums[]) {
        if (nums[i] > 0 && nums[i] <= nums.length) {
            return true;
        } else {
            return false;
        }
    }
}
