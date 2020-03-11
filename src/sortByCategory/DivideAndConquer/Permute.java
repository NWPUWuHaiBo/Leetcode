package sortByCategory.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * <p>
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 */

/**
 * @author haiboWu
 * @create 2020-03-11 18:05
 */
public class Permute {
    public static void main(String[] args) {
        int nums[]={1,2};
        List<List<Integer>> res  = new ArrayList<>();
        List<List<Integer>> permute = new Permute().getPermute(nums,res);
        System.out.println(permute.toString());
    }

    public List<List<Integer>> getPermute(int nums[],List<List<Integer>> res ) {
        ArrayList<Integer> list = new ArrayList();
        backTrack(nums,list,res);
        return res;
    }

    private void backTrack(int[] nums, ArrayList<Integer> list,List<List<Integer>> res ) {
        if(list.size()==nums.length){
            //这里要new 一个新的集合
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backTrack(nums,list,res);
            list.remove(list.size()-1);
        }
    }
}
