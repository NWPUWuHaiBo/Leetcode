package sortByCategory.DoublePointer;

/**
 * @author haiboWu
 * @create 2020-02-28 15:47
 */
public class No_680_ValidPalindrom {
    public boolean isValidPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        for(;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return isValidPalindrome(s,i+1,j)||isValidPalindrome(s,i,j-1);
            }
        }
        return true;
    }
}
