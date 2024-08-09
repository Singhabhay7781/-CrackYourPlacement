class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int direction[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int[] dir : direction) {
                    int nR = i + dir[0];
                    int nC = j + dir[1];

                    if (nR >= 0 && nR < m && nC >= 0 && nC < n && Math.abs(board[nR][nC]) == 1)
                        live++;
                }

                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = -1;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }
}