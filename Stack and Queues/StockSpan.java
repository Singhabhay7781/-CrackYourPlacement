class StockSpanner {
    Stack<int[]> stack;
    int idx = -1;
    public StockSpanner() {
       stack = new Stack<>();
       idx = -1;
    }
    
    public int next(int price) {
        idx = idx+1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            stack.pop();
        }
        int ans = idx - (stack.isEmpty() ? -1 : stack.peek()[1]);
        stack.push(new int[]{price,idx});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */