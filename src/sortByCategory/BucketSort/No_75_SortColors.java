package sortByCategory.BucketSort;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-01 21:01
 */
public class No_75_SortColors {
    @Test
    public void testSort(){

    }
    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length - 1;
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums,++zero,one++);
            }else if(nums[one]==2){
                swap(nums,two--,one);
            }else {
                one++;
            }
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
