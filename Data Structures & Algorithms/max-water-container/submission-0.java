class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxHeight = 0;
        while (left < right)
        {
            int height = Math.min(heights[left], heights[right]) * (right - left);
            if (maxHeight < height)
            maxHeight = height;
            if (heights[left] > heights[right])
            right--;
            else 
            left++;
        }

        return maxHeight;
    }
}
