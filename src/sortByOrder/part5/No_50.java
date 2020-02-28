package sortByOrder.part5;

/**
 * @author haiboWu
 * @create 2020-02-21 19:17
 */
public class No_50 {
    public static void main(String[] args) {
        System.out.println(new No_50().myPow(2, 9));
    }
    public double myPow(double x, int n) {
        if(x==0||n==0)return 1;
        if(n==1)return x;
        if(n<0) return (1/x)*myPow(1/x,-n-1);

        while (n>1){
            if(n%2!=0){
                double temp=x*x;
                n=n/2;
                return x*myPow(temp,n);
            }else{
                double temp=x*x;
                n=n/2;
                return myPow(temp,n);
            }
        }
        return 0;
    }
}
