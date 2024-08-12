class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        StringBuilder str = new StringBuilder();
        findPath(root, ans, str);
        return ans;
    }

    public void findPath(TreeNode root, List<String> ans, StringBuilder str) {
        if (root == null)
            return;

        int len = str.length(); // Store the current length of the StringBuilder
        str.append(root.val);

        if (root.left == null && root.right == null) { // If it's a leaf node
            ans.add(str.toString()); // Add the path to the answer list
        } else {
            str.append("->"); // Add the separator before going to children
            findPath(root.left, ans, str);
            findPath(root.right, ans, str);
        }

        str.setLength(len); // Restore the StringBuilder to its original state
    }
}   