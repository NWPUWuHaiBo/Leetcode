package part5;

/**
 * @author haiboWu
 * @create 2020-02-17 20:15
 */
public class No_42 {
    public static void main(String[] args) {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        if (height == null || height.length <= 3) return 0;
        int res = 0;
        int leftmost = 0, rightmost = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            leftmost = Math.max(leftmost, height[i]);
            rightmost = Math.max(rightmost, height[j]);
            if (leftmost < rightmost) {
                res+=(leftmost-height[i++]);
            }else{
                res+=(rightmost-height[j--]);
            }
        }

        return res;

    }

}
