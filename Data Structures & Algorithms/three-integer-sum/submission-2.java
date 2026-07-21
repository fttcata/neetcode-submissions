class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            int j = i + 1;
            int right = nums.length - 1;
                while (j < right)
                {
                int sum = nums[i] + nums[j] + nums[right];
                    if (sum > 0)
                    right--;
                    else if (sum < 0)
                    j++;
                    else 
                    {
                        if (!res.contains(List.of(nums[i],nums[j],nums[right])))
                        res.add(List.of(nums[i],nums[j],nums[right]));
                        j++;
                    }
                }
        }

        return res;
    }
}
