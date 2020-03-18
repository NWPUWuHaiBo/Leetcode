package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-18 21:58
 */
public class No_78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        backtrack(res,list,nums,0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i <nums.length ; i++) {
            list.add(nums[i]);
            backtrack(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
