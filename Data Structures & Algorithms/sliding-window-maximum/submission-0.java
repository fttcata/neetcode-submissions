class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Priority Queue that will store the subArray of K
        Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        // ArrayList that will store maximums of subarrays
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        
        while (i + k <= nums.length)
        {
            int j = i;
            // Update window
            while (j < nums.length && que.size() < k)
            {
            que.add(nums[j]);
            j++;
            }
            // Get Max Value in the subarray
            list.add(que.poll());

            // Remove the first element of the subarray
            que.clear();
            // Traverse
            i++;
        }
        int m = 0;
        int[] res = new int[list.size()];
        for (int num : list)
        {
            res[m++] = num;
        }
        return res;
    }
}
