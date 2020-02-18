package part4;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-02-16 19:24
 */
public class No_37 {
    public void solveSudoku(char[][] board) {

    }

    public boolean sudokuHelper(char[][] board, int row, int col) {
        if(board==null||board.length!=9||board[0].length!=9)return false;
        //1.找到第一个为空的位置
        while (row < 9 && col < 9) {
            if (board[row][col] == '.') {
                break;
            }
            if (col == 8) {
                col = 0;
                row++;
            } else col++;
        }
        if(row>=9)return true;

        int newRow=row+col/8;
        int newCol=(col+1)%9;

        for (int i = 0; i < 9; i++) {
            if(isValid(board,row,col,i)){
                board[row][col]= (char) (i+'0');
                if(sudokuHelper(board,newRow,newCol)){
                    return true;
                }else {
                    board[row][col]='.';
                }
            }
        }
        return false;

    }

    public boolean isValid(char[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num + '0' || board[row][i] == num + '0') return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + 3 * (row / 3)][j + 3 * (col / 3)] == num + '0') {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testSolveSudoku() {

    }
}
