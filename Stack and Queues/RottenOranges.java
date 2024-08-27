

class Solution
{
     class Pair {
        int row, col, time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int count_fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    count_fresh++;

            }
        }

        int delrow[] = { 0, 0, -1, 1 };
        int delcol[] = { -1, 1, 0, 0 };
        int tm = 0;
        int count = 0;

        while (!q.isEmpty()) {
            Pair orange = q.poll();
            int r = orange.row;
            int c = orange.col;
            int t = orange.time;
            tm = Math.max(t, tm);
            for (int i = 0; i < 4; i++) {
                int nr = r + delrow[i];
                int nc = c + delcol[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                    q.add(new Pair(nr, nc, t + 1));
                    vis[nr][nc] = 2;
                    count++;
                }
            }
        }

        if (count_fresh != count)
            return -1;

        return tm;
    }
}