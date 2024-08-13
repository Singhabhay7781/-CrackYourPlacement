class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        double pre = 1, suff = 1;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;
            pre *= nums[i];
            suff *= nums[n - i - 1];
            max = Math.max(max, Math.max(pre, suff));
        }
        return (int) max;
    }
}