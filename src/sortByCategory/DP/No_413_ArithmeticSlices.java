package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-03-23 20:05
 */
public class No_413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null||A.length<=2){
            return 0;
        }
        int dp[]=new int [A.length];
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]+=dp[i-1]+1;
            }
        }
        int sum=0;
        for(int i:dp){
            sum+=i;
        }
        return sum;
    }
}
