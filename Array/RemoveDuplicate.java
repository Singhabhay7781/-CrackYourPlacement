class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int low = 1;

        for(int high=1;high<nums.length;high++){
            if(nums[high] != nums[low-1]){
                nums[low] = nums[high];
                low++;
            }
        }
        return low;
    }
}