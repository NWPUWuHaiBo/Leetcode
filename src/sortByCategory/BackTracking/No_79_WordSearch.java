package sortByCategory.BackTracking;

/**
 * @author haiboWu
 * @create 2020-03-13 19:36
 */
public class No_79_WordSearch {
    public static void main(String[] args) {

        /**
         * :[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
         * 			"ABCESEEEFS"
         */


        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new No_79_WordSearch().exist(board, "ABCESEEEFS"));
    }

    /*   public boolean exist(char[][] board, String word) {
           boolean visited[][] = new boolean[board.length][board[0].length];

           for (int i = 0; i < board.length; i++) {
               for (int j = 0; j < board[0].length; j++) {
                   if (board[i][j] == word.charAt(0)) {
                       dfs(board, word, 0, i, j, visited);
                       if (flag) {
                           return true;
                       }
                   }
               }
           }
           return false;
       }

       int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
       boolean flag = false;

       private void dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
           if (index == word.length()) {
               flag = true;
               return;
           }
           if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]) {
               return;
           }
           for (int[] dir : directions) {
               visited[i][j] = true;
               dfs(board, word, index + 1, i + dir[0], j + dir[1], visited);
               visited[i][j] = false;
           }
       }*/
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
