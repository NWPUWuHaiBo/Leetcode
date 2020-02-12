package part3;

/**
 * @author haiboWu
 * @create 2020-02-11 16:37
 */
public class No_27 {
    public static void main(String[] args) {
            int []nums={3,2,2,3};

    }
    public int removeElement(int[] nums, int val) {
        if(nums.length<=0)return 0;
        int left=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[left++]=nums[i];
            }
        }
        return left;
    }
}
