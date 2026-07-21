class Solution {
    public int lengthOfLIS(int[] nums) {
        // DP array which tracks the length of longest increasing subsequence of each pos
        int[] dp = new int[nums.length];
        int n = nums.length;
        // Last element always has 1;
        dp[dp.length - 1] = 1;
        int maxLength = 1;

        // Build the dp array
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) 
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
}
      
    }

