class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [][] freq = new int[2001][2];

        for (int i = 0; i < nums.length; i++)
        {
            freq[nums[i] + 1000][0]++;
            freq[nums[i] + 1000][1] = nums[i] + 1000;
        }

        for (int i = 1; i < freq.length; i++)
        {
            int[] key = freq[i];
            int j = i - 1;
            while (j>=0 && key[0] < freq[j][0])
            {
                freq[j+1] = freq[j];
                j--;
            }
            freq[j+1] = key;
        }

        int[] res = new int[k];

        int j = 0;
        for (int i = freq.length - 1; i >= 0; i--)
        {
            if (j < k)
            {
                res[j] = freq[i][1] - 1000;
                j++;
            }
            else break;
        }

        return res;
    }
}
