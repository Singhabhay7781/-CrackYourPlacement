class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, 0, 0, sb, result);
        return result;
    }

    public void backtrack(int n, int open, int close, StringBuilder sb, List<String> result) {
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(n, open + 1, close, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(n, open, close + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}