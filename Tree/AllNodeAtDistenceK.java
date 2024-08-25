/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        if (root == null)
            return;
        if (root.left != null) {
            parent.put(root.left, root);
            markParent(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            markParent(root.right, parent);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);

        while (k-- > 0) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.remove();
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                    visited.add(curr.right);
                }
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    queue.add(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (TreeNode curr : queue) {
            ans.add(curr.val);
        }
        return ans;
    }
}