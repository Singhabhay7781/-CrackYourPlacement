
class Solution {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // int row[] = new int[m]; mat[..][0]
        // int col[] = new int[n]; mat[0][..]
        int col0 = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {

                    mat[i][0] = 0;
                    if (j != 0) {
                        mat[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] != 0) {
                    if (mat[0][j] == 0 || mat[i][0] == 0) {
                        mat[i][j] = 0;
                    }
                }
            }
        }

        if (mat[0][0] == 0) {
            for (int j = n - 1; j >= 0; j--) {
                mat[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = m - 1; i >= 0; i--) {
                mat[i][0] = 0;
            }
        }

    }
}