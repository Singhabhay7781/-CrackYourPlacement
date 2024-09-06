class Solution {
   public int majorityElement(int[] nums) {
    int majorityCandidate = nums[0];
    int count = 1;

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == majorityCandidate) {
            count++;
        } else {
            count--;
            if (count == 0) {
                majorityCandidate = nums[i];
                count = 1;
            }
        }
    }

    return majorityCandidate;
}

}