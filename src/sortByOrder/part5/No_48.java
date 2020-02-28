package sortByOrder.part5;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-02-20 20:40
 */
public class No_48 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        new No_48().rotate(matrix);
        System.out.println(Arrays.toString(matrix));
    }

    public void rotate(int[][] matrix) {
        if (matrix.length == 1) return;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int n = matrix.length;
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            top++;
            bottom--;
            left++;
            right--;
            n -= 2;
        }
    }
}
