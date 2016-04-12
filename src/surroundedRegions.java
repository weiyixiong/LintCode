import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by winney on 16/4/12.
 */
public class surroundedRegions {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    //非推荐答案 因为是深度优先导致容易溢出
    public static void surroundedRegions(char[][] board) {
        if (board.length == 0) {
            return;
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j] == 'O') {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    boolean res = surroundedRegionsHelper(board, i, j, visited);
                    if (res) {
                        for (int k = 0; k < visited.length; k++) {
                            for (int l = 0; l < visited[0].length; l++) {
                                if (visited[k][l]) {
                                    board[k][l] = 'X';
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    public static boolean surroundedRegionsHelper(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        if (i <= 0 || i >= board.length - 1 || j <= 0 || j >= board[0].length - 1) {
            return false;
        }
        char top = board[i - 1][j];
        char left = board[i][j - 1];
        char right = board[i][j + 1];
        char bottom = board[i + 1][j];
        boolean result = true;
        int k = 0;
        if (top == 'O' && !visited[i - 1][j]) {
            result &= surroundedRegionsHelper(board, i - 1, j, visited);
        }
        if (left == 'O' && !visited[i][j - 1]) {
            result &= surroundedRegionsHelper(board, i, j - 1, visited);
        }
        if (right == 'O' && !visited[i][j + 1]) {
            result &= surroundedRegionsHelper(board, i, j + 1, visited);
        }
        if (bottom == 'O' && !visited[i + 1][j]) {
            result &= surroundedRegionsHelper(board, i + 1, j, visited);
        }
        return result;
    }


    //宽度优先
   // 正确答案


    private static Queue<Integer> queue = null;
    private static char[][] board;
    private static int rows = 0;
    private static int cols = 0;

    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0) return;
        queue = new LinkedList<Integer>();
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) { // **important**
            enqueue(i, 0);
            enqueue(i, cols - 1);
        }

        for (int j = 1; j < cols - 1; j++) { // **important**
            enqueue(0, j);
            enqueue(rows - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols,
                    y = cur % cols;

            if (board[x][y] == 'O') {
                board[x][y] = 'D';
            }

            enqueue(x - 1, y);
            enqueue(x + 1, y);
            enqueue(x, y - 1);
            enqueue(x, y + 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'D') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        queue = null;
        board = null;
        rows = 0;
        cols = 0;
    }

    public static void enqueue(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O') {
            queue.offer(x * cols + y);
        }
    }

    public static void main(String[] args) throws Exception {
        char[][] data = {
                {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
        surroundedRegions(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
