class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int r = 0;

        for (int i = 0; i < nums.length; i++) {

            // 1. Remove out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.addLast(i);

            // 4. Record answer
            if (i >= k - 1) {
                res[r++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}