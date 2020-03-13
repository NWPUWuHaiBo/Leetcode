package sortByCategory.BackTracking;

/**
 * @author haiboWu
 * @create 2020-03-13 19:36
 */
public class No_79_WordSearch {
    private final static int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int col = board[0].length;
        int row = board.length;
        boolean isVisited[][] = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (isExist(board, word.toCharArray(), isVisited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, char[] wordArray, boolean[][] isVisited, int index, int col, int row) {
        if (index == wordArray.length) {
            return true;
        }
        if (col < 0 || col >= board[0].length || row < 0 || row >= board.length || isVisited[row][col] || wordArray[index] != board[row][col]) {
            return false;
        }
        isVisited[row][col] = true;
        for (int[] direction : directions) {
            if (isExist(board, wordArray, isVisited, index + 1, col + direction[0], row + direction[1])) {
                return true;
            }
        }
        isVisited[row][col] = false;
        return false;
    }
}
