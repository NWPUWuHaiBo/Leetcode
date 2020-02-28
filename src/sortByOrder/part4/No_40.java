package sortByOrder.part4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-02-16 20:16
 */
public class No_40 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length <= 0 || target <= 0) return result;
        Arrays.sort(candidates);
        getHelper(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void getHelper(List<List<Integer>> result, int[] candidates, int target, int index, List<Integer> curArry) {
//        && curArry.size() != 0
        if (target == 0) {
            result.add(new ArrayList<>(curArry));
        }

        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) continue;
            curArry.add(candidates[i]);
            getHelper(result, candidates, target - candidates[i], i+1, curArry);
            curArry.remove(curArry.size() - 1);
        }

    }

    @Test
    public void testcombinationSum() {
        int nums[] = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum(nums, 8));
    }
}
