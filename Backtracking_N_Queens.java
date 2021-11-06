public class Backtracking_N_Queens {
    final int N = 4;

    public boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // check row on left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // check lower diagonal on left side
        for (i = row, j = col; j >= N && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    // recursive utility function to solve N Queens
    public boolean solveNQutil(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQutil(board, col + 1) == true)
                    return true;
                else {
                    board[i][col] = 0;
                }
            }
        }
        return false;
    }

    public boolean solveNQ() {
        int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        if (solveNQutil(board, 0) == false)
            return false;

        return true;
    }

}
