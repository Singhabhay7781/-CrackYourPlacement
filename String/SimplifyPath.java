import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String paths[] = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String curr : paths) {
            if (curr.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Move up one directory
                }
            } else if (!curr.equals("") && !curr.equals(".")) {
                stack.push(curr); // Add valid directory to the stack
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}