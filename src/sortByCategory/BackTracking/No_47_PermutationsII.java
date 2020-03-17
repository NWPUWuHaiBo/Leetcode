package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-16 18:36
 */
public class No_47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        if(nums.length==0)return res;
        Arrays.sort(nums);
        boolean visited[]=new boolean[nums.length];
        ArrayList<Integer> cur=new ArrayList();
        backtrack(nums,cur,visited,res);
        return res;
    }
    private void backtrack(int []nums, List<Integer> cur, boolean[]visited, List<List<Integer>> res ){
        if(cur.size()==nums.length){
            res.add(new ArrayList(cur));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]&&!visited[i-1]){
                continue;
            }
            if(visited[i]){
                continue;
            }
            cur.add(nums[i]);
            visited[i]=true;
            backtrack(nums,cur,visited,res);
            cur.remove(cur.size()-1);
            visited[i]=false;
        }
    }
}
