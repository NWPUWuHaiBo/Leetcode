package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-16 18:34
 */
public class No_46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if (nums.length == 0) return list;
        List<Integer> cur = new ArrayList();
        backTrack(nums, list, cur);
        return list;
    }

    private void backTrack(int nums[], List<List<Integer>> list, List cur) {
        if (cur.size() == nums.length) {
            list.add(new ArrayList(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            backTrack(nums, list, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
