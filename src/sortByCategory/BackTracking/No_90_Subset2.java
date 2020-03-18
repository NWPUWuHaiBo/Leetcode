package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-18 22:05
 */
public class No_90_Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        boolean visited[]=new boolean[nums.length];
        backtrack(res,list,0,visited,nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int start, boolean[] visited, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = start; i <nums.length ; i++) {
            if(i!=0&&nums[i]==nums[i-1]&&!visited[i-1]){
                continue;
            }
            list.add(nums[i]);
            visited[i]=true;
            backtrack(res,list,i+1,visited,nums);
            list.remove(list.size()-1);
            visited[i]=false;
        }
    }
}
