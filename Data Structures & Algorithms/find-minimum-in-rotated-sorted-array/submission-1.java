class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r)
        {
            // We are in an subarray that's ordered!!!!
            if (nums[l] < nums[r])
            {
                res = Math.min(res,nums[l]);
                break;
            }

            // Do binary search
            int m = l + (r - l) / 2;
            // Get minim value between res and nums[m]
            res = Math.min(res,nums[m]);
            // Modify pointers 
            if (nums[m] >= nums[l])
            l = m + 1;
            else r = m -1;
        }
        return res;
    }
}
