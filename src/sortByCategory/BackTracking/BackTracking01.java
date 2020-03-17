package sortByCategory.BackTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-17 21:20
 */
public class BackTracking01 {
    @Test
    public void test(){

        List<Integer> ints = Arrays.asList(1,2,3);
        List<List<Integer>> subsets = subsets(ints);
        System.out.println(subsets.toString());
    }

    @Test
    public void test2(){
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
    //子集问题，前序遍历，所有的节点都是结果
    public List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(res, list, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> list, List<Integer> nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.size(); i++) {
            list.add(nums.get(i));
            backtrack(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    //组合问题，所有的叶子节点都是结果
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> res=new ArrayList<>();
        if(n<=0||k<=0){
            return res;
        }
        ArrayList list=new ArrayList();
        backtrack2(res,list,n,k,1);
        return res;

    }

    private void backtrack2(List<List<Integer>> res, ArrayList list, int n, int k, int start) {
        //到达树的底部
        if(k==list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        //i从start开始递增
        for (int i = start; i <=n ; i++) {
            //做选择
            list.add(i);
            backtrack2(res,list,n,k,i+1);
            list.remove(list.size()-1);
        }
    }
}
