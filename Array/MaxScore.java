class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;
        int sum = 0;
        
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        sum = leftSum;
        int r = n - 1;
        for (int l = k - 1; l >= 0; l--) {
            leftSum -= cardPoints[l];
            rightSum += cardPoints[r];
            r--;
            sum =Math.max(sum, leftSum + rightSum);
        }
        return sum;
    }
}