package part4;

/**
 * @author haiboWu
 * @create 2020-02-15 18:26
 */
public class No_35 {
    public static void main(String[] args) {

    }
    public static int searchInsert(int[] nums, int target) {
        int n=nums.length;
        if(n==0)return 0;
        int i=0;
        while (i<n){
            if(nums[i]>=target){
                break;
            }else {
                i++;
            }
        }
        return i;

    }
}
