package sortByCategory.DivideAndConquer;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-03-09 16:16
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        new QuickSortDemo().quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public void quicksort(int nums[],int left,int right) {
            if(left<right){
                int index=getIndex(nums, left, right);
                quicksort(nums,left,index);
                quicksort(nums,index+1,right);
            }
    }

    private int getIndex(int[] nums, int left, int right) {
        int temp=nums[left];
        while (left<right){
            while (left<right&&nums[right]>=temp){
                right--;
            }
            nums[left]=nums[right];
            while (left<right&&nums[left]<=temp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=temp;
        return left;
    }
}
