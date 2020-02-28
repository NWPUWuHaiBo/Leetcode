package sortByOrder.part5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-02-19 20:03
 */
public class No_47 {
    public static void main(String[] args) {
        int num[] = {1, 1, 2};
        List<List<Integer>> permute = new No_47().permute(num);
        System.out.println(permute.toString());
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited, 0);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, boolean[] visited, int index) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
                visited[i] = true;
                tmp.add(nums[i]);
                backtrack(res, nums, tmp, visited, index);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
