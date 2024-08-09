

class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        
        if(root == null) return;
        
        while(root != null){
            if(root.data == key){
                if(root.left != null){
                    Node temp = root.left;
                    while(temp.right != null){
                        temp =  temp.right;
                    }
                    pre[0] = temp;
                }
                
                 if(root.right != null){
                    Node temp = root.right;
                    while(temp.left != null){
                        temp =  temp.left;
                    }
                    suc[0] = temp;
                }
                
                return;
            } else if(root.data > key){
                suc[0] = root;
                root = root.left;
            } else {
                pre[0] = root;
                root = root.right;
            }
        }
    }
}