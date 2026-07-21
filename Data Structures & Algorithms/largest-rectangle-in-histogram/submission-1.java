public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Finding the nearest smallest bar on the right
        for (int i = 0; i < n; i++) {
            leftMost[i] = -1;
            // Keep popping until we reached a smaller bar on the right
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // When we reached a smaller bar, leftMost[i] = the index of the smaller bar
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear stack
        stack.clear();

        // Finding the nearest less bar on the left
        for (int i = n - 1; i >= 0; i--) {
            rightMost[i] = n;
            // Keep popping until we find a less bar on the left
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If bar is less, rightMost[i] = barIndex;
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            leftMost[i] += 1;
            rightMost[i] -= 1;
            // Calculate width using rightMost - leftMost
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }
        return maxArea;
    }
}
