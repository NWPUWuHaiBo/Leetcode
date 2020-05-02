package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-04-22 11:11
 */
public class No_376_WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int up[]=new int[nums.length];
        int down[]=new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]<nums[j]){
                    down[i]=Math.max(down[i],up[j]+1);
                }else if(nums[i]>nums[j]){
                    up[i]=Math.max(up[i],down[j]+1);
                }
            }
        }
        return 1+Math.max(down[nums.length-1],up[nums.length-1]);
    }
    public int wiggleMaxLength2(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int down=1,up=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                up=down+1;
            }else if(nums[i]<nums[i-1]){
                down=up+1;
            }
        }
        return Math.max(up,down);
    }
}
