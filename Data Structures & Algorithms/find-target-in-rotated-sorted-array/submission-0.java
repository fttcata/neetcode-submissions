public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        // Trying to find the ordered subarrays
        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int pivot = l;

        // Perform binary search on the ordered subarrays
        int result = binarySearch(nums, target, 0, pivot - 1);
        if (result != -1) {
            return result;
        }
        
        // if result = -1; return it, else return the value
        return binarySearch(nums, target, pivot, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}