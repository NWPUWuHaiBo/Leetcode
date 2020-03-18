package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-18 22:23
 */
public class No_131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        if(s.length()==0)return res;
        backtrack(res,list,s);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> list, String s) {
        if(s.length()==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(isPalindrom(s,0,i)){
                list.add(s.substring(0,i+1));
                backtrack(res,list,s.substring(i+1));
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrom(String s, int start, int end) {
        while (start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
