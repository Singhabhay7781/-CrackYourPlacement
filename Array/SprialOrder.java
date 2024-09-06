class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        if (mat == null || mat.length == 0) {
            return res;
        }

        int sr = 0; // starting row
        int lr = mat.length - 1; // last row
        int sc = 0; // starting column
        int lc = mat[0].length - 1; // last column

        while (sr <= lr && sc <= lc) {
            // Traverse from left to right along the top row
            for (int j = sc; j <= lc; j++) {
                res.add(mat[sr][j]);
            }
            sr++; // Move the starting row down

            // Traverse from top to bottom along the right column
            for (int i = sr; i <= lr; i++) {
                res.add(mat[i][lc]);
            }
            lc--; // Move the last column to the left

            // Traverse from right to left along the bottom row, if any rows remain
            if (sr <= lr) {
                for (int j = lc; j >= sc; j--) {
                    res.add(mat[lr][j]);
                }
                lr--; // Move the last row up
            }

            // Traverse from bottom to top along the left column, if any columns remain
            if (sc <= lc) {
                for (int i = lr; i >= sr; i--) {
                    res.add(mat[i][sc]);
                }
                sc++; // Move the starting column to the right
            }
        }

        return res;
    }
}
