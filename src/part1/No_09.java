package part1;

/**
 * @author haiboWu
 * @create 2020-01-31 18:36
 */
public class No_09 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x){

        if(x<0||(x%10==0&&x!=0))return false;

        int reverse=0;
        while(x>reverse){
            reverse=reverse*10+x%10;
            x=x/10;
        }
        return reverse==x ||reverse/10==x;
    }
}
