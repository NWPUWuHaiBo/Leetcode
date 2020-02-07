package part2;

import java.util.HashMap;

/**
 * @author haiboWu
 * @create 2020-02-03 9:54
 */
public class No_14 {
    public static void main(String[] args) {
        String strs[]={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String []strs){
        int len=strs.length;
        if(len==0)return "";
        if(len==1)return strs[0];
        int min=strs[0].length();
        for(int i=1;i<len;i++){
           int start=0;
            while(true){
                if(start>=strs[i].length()||start>=strs[0].length()||strs[0].charAt(start)!=strs[i].charAt(start)){
                    break;
                }
                start++;
            }
            min=Math.min(min,start);
        }
        return strs[0].substring(0,min);
    }
}
