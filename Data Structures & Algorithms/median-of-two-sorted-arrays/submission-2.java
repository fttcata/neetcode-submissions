class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       // Total length of combined arrays
       int total = nums1.length + nums2.length;

       // We only need to move until half of both arrays
       int half = total / 2 + 1;

       // Index for nums1, nums2, and counting the pos
       int i = 0;
       int j = 0;
       int count = 0 ;

       // 2 variables for the numbers, prevNum only comes into play when total is even
       int num = 0;
       int prevNum = 0;
       // Traversing up until half
       while (count < half)
       {
         // Keep track of previous number
         prevNum = num;
         // Check which one is bigger, since it's sorted
         if (i < nums1.length && j < nums2.length)
         {
         if(nums1[i] >= nums2[j])
          num = nums2[j++];
         else num = nums1[i++];
         }
         else if (i == nums1.length)
         num = nums2[j++];
         else num = nums1[i++];
         count++;
       }
       
       // Return median
       if (total % 2 == 0)
       return ((double)(num + prevNum) / 2);
       else return (double)num;


    }
}
