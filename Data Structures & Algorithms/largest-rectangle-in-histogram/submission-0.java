class Solution {
    public int largestRectangleArea(int[] heights) {
        int largestRectangle = -1;

        // Heights pointer, check for every entry
        int i = 0;
        while (i < heights.length)
        {
            int width = 1;

            // Check Left
            if (i != 0)
            {
                int j = i - 1;
                int num = heights[i];
                while (j >= 0 && num <= heights[j])
                {
                    width++;
                    j--;
                }
            }
            // Check Right
            if (i != heights.length - 1)
            {
                int j = i + 1;
                int num = heights[i];
                while (j <= heights.length - 1 && num <= heights[j])
                {
                    width++;
                    j++;
                }
            }
            largestRectangle = Math.max((width*heights[i]), largestRectangle);
            i++;
        }
        return largestRectangle;


        
    }
}
