package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-17 21:51
 */
public class No_40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length <= 0) return res;
        ArrayList list = new ArrayList();
        Arrays.sort(candidates);
        boolean visited[]=new boolean[candidates.length];
        backtrack(res, list, candidates, target, 0,visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList list, int[] candidates, int target, int start,boolean visited[]) {
        if (target == 0 && list.size() != 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if(i!=0&&candidates[i]==candidates[i-1]&&!visited[i-1]){
                continue;
            }
            list.add(candidates[i]);
            visited[i]=true;
            backtrack(res, list, candidates, target - candidates[i], i+1,visited);
            list.remove(list.size() - 1);
            visited[i]=false;
        }
    }
}
