package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-17 22:24
 */
public class No_216_CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0||n<=0)return res;
        ArrayList list = new ArrayList();
        backtrack(res, list, k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList list, int k, int n, int start) {
        if(k==list.size()&&n==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <=9 ; i++) {
            list.add(i);
            backtrack(res,list,k,n-i,i+1);
            list.remove(list.size()-1);
        }
    }

}
