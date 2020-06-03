package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-17 21:51
 */
public class No_39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length <= 0) return res;
        ArrayList list = new ArrayList();
        Arrays.sort(candidates);
        backtrack(res, list, candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList list, int[] candidates, int target, int start) {
        if (target == 0 && list.size() != 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            backtrack(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
