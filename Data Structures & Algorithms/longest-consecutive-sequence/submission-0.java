class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0 ; i < nums.length; i++)
        {
            set.add(nums[i]);
        }

        int maxLen = 0;
        for (int i = 0 ; i < nums.length; i++)
        {
            int num = nums[i];
            if (!set.contains(num - 1))
            {
                int len = 0;
                while (set.contains(num))
                {
                    num++;
                    len++;
                }
                if (maxLen < len)
            maxLen = len;
            }
        }

        return maxLen;
    }
}
