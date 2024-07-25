class Solution {
    public void moveZeroes(int[] nums) {
        int low = 0;
        for (int high = 0; high < nums.length; high++) {
            if (nums[high] != 0) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
            }
        }
    }
}