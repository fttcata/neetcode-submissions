class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean zero = false;
        boolean zero2 = false;
        int prod = 1;

        for (int i = 0 ; i <nums.length; i++)
        {
            if (nums[i] == 0)
            {
                if (!zero)
                zero = true;
                else zero2 = true;
            }
            else prod *= nums[i];
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (zero2)
            nums[i] = 0;
            else if (nums[i] == 0)
            nums[i] = prod;
            else if (zero) nums[i] = 0;
            else nums[i] = prod / nums[i];
        }

        return nums;
    }
}  
