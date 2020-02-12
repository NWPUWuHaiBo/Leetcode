package part3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-02-07 21:28
 */
public class No_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis2(int n){
        return null;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;
        getParenthesis("",n,list,0,0);
        return list;
    }

    public static void getParenthesis(String cur,int n, List<String> list, int left, int right) {
        if(right==n){
            list.add(cur);
            return;
        }

        if(left<right)return;

        if(left>right){
            getParenthesis(cur+")",n,list,left,right+1);
        }
        if(left<n){
            getParenthesis(cur+"(",n,list,left+1,right);
        }
    }
}
