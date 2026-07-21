class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];

        for (int i = 1 ; i < height.length; i++)
        {
            if (left[i-1] < height[i])
            {
                left[i] = height[i];
            }
            else left[i] = left[i-1];
        }

        for (int i = height.length - 2; i >= 0;  i--)
        {
            if (right[i + 1] < height[i])
            {
                right[i] = height[i];
            }
            else right[i] = right[i+1];
        }

        int sum = 0;
        for (int i = 0 ; i < height.length; i++)
        {
            sum += Math.min(left[i],right[i]) - height[i];
        }

        return sum;
    }
}
