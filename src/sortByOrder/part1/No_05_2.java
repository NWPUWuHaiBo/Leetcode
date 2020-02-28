package sortByOrder.part1;

/**
 * @author haiboWu
 * @create 2020-01-30 19:28
 */
public class No_05_2 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababd"));
    }
    public static String longestPalindrome(String s){
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen=1;
        String res=s.substring(0,1);
        for(int i=0;i<n-1;i++){
            String s1=getMaxString(s,i,i);
            String s2=getMaxString(s,i,i+1);
            String maxLenStr=s1.length()>s2.length()?s1:s2;
            if(maxLenStr.length()>maxLen){
                maxLen=maxLenStr.length();
                res=maxLenStr;
            }
        }
        return res;
    }
    public static String getMaxString(String s,int left,int right){
        int n=s.length();

        while(left>=0&&right<n){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        return s.substring(left+1,right);

    }

}
