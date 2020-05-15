package Algorithm;

/**
 * @author haiboWu
 * @create 2020-05-14 23:15
 */
public class No_01_LuoxuanMatrix {
    public static void main(String[] args) {

        getMatrix(3);
    }

    private static void getMatrix(int n) {
        int matrix[][] = new int[n + 1][n + 1];

        int l = 0;
        int i = 1;
        for (int k = n; k > 0; k = k - 2) {
            System.out.println(l+"---");
            //up
            for (int j = 0; j < k - 1; j++) {
                matrix[l][j + l] = i++;
            }
            //right
            for (int j = 0; j < k - 1; j++) {
                matrix[j + l][n - 1 - l] = i++;
            }
            //down
            for (int j = 0; j < k - 1; j++) {
                matrix[n - 1 - l][n - 1 - j - l] = i++;
            }
            //left
            for (int j = 0; j < k - 1; j++) {
                matrix[n - 1 - j - l][l] = i++;
            }
            if(k==1){
                matrix[l][l]=i++;
            }
            l += 1;
        }
        for (int j = 0; j < n; j++) {
            for (int m = 0; m < n; m++) {
                System.out.print(matrix[j][m] + " ");
            }
            System.out.println();
        }
    }

}
