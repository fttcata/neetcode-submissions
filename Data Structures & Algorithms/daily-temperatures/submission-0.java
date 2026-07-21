class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Result array
        int[] result = new int[temperatures.length];
        // Data structure to track index
        Stack<Integer> stack = new Stack<>();

        // Traverse the array
        for (int i = 0  ; i < temperatures.length; i++)
        {
            // If Temperatures at any previous position is lower than temperatures at current
            // We pop stack and calculate the days
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
