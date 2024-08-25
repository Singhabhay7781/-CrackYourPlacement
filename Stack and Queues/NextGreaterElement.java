class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans[] = new int[n1];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=n2-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            } else {
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }

        for(int i=0;i<n1;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}