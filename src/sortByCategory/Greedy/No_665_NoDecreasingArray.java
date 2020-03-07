package sortByCategory.Greedy;

/**
 * @author haiboWu
 * @create 2020-03-05 16:51
 */
public class No_665_NoDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int cnt=0;
        for(int i=1;i<nums.length&&cnt<2;i++){
            if(nums[i]>=nums[i-1]){
                continue;
            }
            cnt++;
            if(i-2>=0&&nums[i-2]>nums[i]){
                nums[i]=nums[i-1];
            }else{
                nums[i-1]=nums[i];
            }
        }
        return cnt<2;
    }
}
