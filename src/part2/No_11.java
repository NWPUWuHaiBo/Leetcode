package part2;

/**
 * @author haiboWu
 * @create 2020-02-02 10:24
 */
public class No_11 {
    public static void main(String[] args) {
        int arr[]={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
    public static int maxArea(int []height){
        int n=height.length,m=0;
        int max=0;
        if(n<=1)return 0;
        while(m<n){
            max=Math.max(Math.min(height[m],height[n-1])*(n-m-1),max);
            if(height[m]<height[n-1]){
                m++;
            }else{
                n--;
            }
        }
        return max;

    }

}
