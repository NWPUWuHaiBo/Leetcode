package part4;

import org.junit.Test;

import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-02-16 20:16
 */
public class No_39 {
    public static List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length <= 0 || target <= 0) return result;
        Arrays.sort(candidates);
        getHelper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void getHelper(int[] candidates, int target, int index, List<Integer> curArry) {
        if (target == 0 && curArry.size() != 0) {
            result.add(new ArrayList<>(curArry));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                curArry.add(candidates[i]);
                getHelper(candidates, target - candidates[i], i, curArry);
                curArry.remove(curArry.size() - 1);
            }
        }

    }

    @Test
    public void testcombinationSum() {
        int nums[] = new int[]{2,3,5};
        System.out.println(combinationSum(nums, 8));
    }
}
