class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        
        for(char ch : S.toCharArray()){
            int ascii = (int)ch;
            if(ascii >= 48 && ascii<=57){
                stack.push(ch-48);
            }
            else {
                int v2 = stack.pop();
                int v1 = stack.pop();
                if(ch=='+') stack.push(v1+v2);
                if(ch=='-') stack.push(v1-v2);
                if(ch=='*') stack.push(v1*v2);
                if(ch=='/') stack.push(v1/v2);
                
            }
        }
        return stack.peek();
    }
}