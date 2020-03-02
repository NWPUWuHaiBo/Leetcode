package sortByCategory.Greedy;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-03-01 21:15
 */
public class No_455_assignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while (i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
