package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-16 19:13
 */
public class No_77_Combainations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        if(n<1||k<=0)return res;
        ArrayList<Integer> cur=new ArrayList<>();
        boolean visited[]=new boolean[n+1];
        backtrack( n, k,res,cur,visited);
        return res;
    }

    private void backtrack(int n, int k, List<List<Integer>> res, ArrayList<Integer> cur, boolean[] visited) {
        if(cur.size()==k){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(cur.contains(i)){
                continue;
            }
            cur.add(i);
            visited[i]=true;
            backtrack(n,k,res,cur,visited);
            cur.remove(cur.size()-1);
            visited[i]=false;
        }
    }
}
