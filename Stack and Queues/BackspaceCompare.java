class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        // Process string s
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stackS.push(c);
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }

        // Process string t
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stackT.push(c);
            } else if (!stackT.isEmpty()) {
                stackT.pop();
            }
        }

        // Compare final strings after processing backspaces
        return stackS.equals(stackT);
    }
}