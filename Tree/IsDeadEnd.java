

/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class Solution
{
    public static boolean isDeadEnd(Node root)
    {
       return deadEnd(root,0,Integer.MAX_VALUE);
    }
    
    public static boolean deadEnd(Node root,int lower,int upper){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.data-lower == 1 && upper-root.data == 1){
                return true;
            }
            else 
                return false;
        }
        
        return deadEnd(root.left,lower,root.data) || deadEnd(root.right,root.data,upper);
    }
}