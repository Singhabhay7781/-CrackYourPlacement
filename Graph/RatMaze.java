
class Solution {
    static int[] delRow = { -1 , 0, +1, 0};
    static int[] delCol = {0,+1,0,-1};
    static String direction = "URDL";
    
    public boolean isValid(int[][]mat,int row,int col,int n){
        if(row>=0 && row<n && col>=0 && col<n && mat[row][col] == 1){
            return true;
        }
        return false;
    }
    
    public void maze(int row,int col,int[][]mat,int n,ArrayList<String> ans,
    StringBuilder temp){
        if(row==n-1 && col==n-1){
            ans.add(temp.toString());
            return;
        }
        mat[row][col] = 0;
        
        for(int i=0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if(isValid(mat,nRow,nCol,n)){
                temp.append(direction.charAt(i));
                maze(nRow,nCol,mat,n,ans,temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
        mat[row][col] = 1;
    }
    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        if(mat[0][0] == 0 || mat[n-1][n-1] == 0){
            return ans;
        }
        maze(0,0,mat,mat.length,ans,temp);
        return ans;
    }
}