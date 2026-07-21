class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suf = new int[nums.length];
        int[] pref = new int[nums.length];

        for (int i = 0 ; i < pref.length; i++)
        {
            pref[i] = 1;
            suf[i] = 1;
        }
        
        for (int i = nums.length - 2; i >= 0; i--)
        {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        for (int i = 1; i < nums.length; i++)
        {
            pref[i] = nums[i-1] * pref[i-1]; 
        }

        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = pref[i] * suf[i];
        }

        return nums;
    }
}  
