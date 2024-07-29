class Solution {
    public int[][] floodFill(int[][] img, int sr, int sc, int newColor) {
        int m = img.length;
        int n = img[0].length;
        int iniColor = img[sr][sc];
        int ans[][] = img;

        dfs(img, ans, sr, sc, iniColor, newColor);

        return ans;

    }

    public void dfs(int img[][], int ans[][], int row, int col, int iniColor, int newColor) {
        int m = img.length;
        int n = img[0].length;
        img[row][col] = newColor;

        int delrow[] = { -1, +1, 0, 0 };
        int delcol[] = { 0, 0, -1, +1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + delrow[i];
            int newCol = col + delcol[i];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    img[newRow][newCol] == iniColor && ans[newRow][newCol] != newColor) {
                dfs(img, ans, newRow, newCol, iniColor, newColor);
            }

        }
    }
}