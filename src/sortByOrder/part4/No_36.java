package sortByOrder.part4;

import java.util.HashMap;

/**
 * @author haiboWu
 * @create 2020-02-15 18:47
 */
public class No_36 {
    public static void main(String[] args) {
        boolean[] check = new boolean[9];
        System.out.println(check[0]);
    }

    public static boolean isValidSudoku(char[][] board) {
        //遍历行
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int c = board[i][j] - '1';
                    if (check[c]) return false;
                    else {
                        check[c] = true;
                    }
                }
            }
        }
        //遍历列
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int c = board[i][j] - '1';
                    if (check[c]) return false;
                    else {
                        check[c] = true;
                    }
                }
            }
        }
        //遍历box
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[j + (i / 3) * 3][k + (i % 3) * 3] != '.') {
                        int c = board[j + (i / 3) * 3][k + (i % 3) * 3] - '1';
                        if (check[c]) return false;
                        else {
                            check[c] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
