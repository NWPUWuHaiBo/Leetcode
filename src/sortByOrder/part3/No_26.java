package sortByOrder.part3;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-02-11 16:29
 */
public class No_26 {
    public static void main(String[] args) {
        int []nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int slow=0,count=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[slow]){
                continue;
            }else{
                nums[++slow]=nums[i];
                count++;

            }
        }
        return count;
    }
}
