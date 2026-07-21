class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int total = nums1.length + nums2.length;
        int [] merged = new int[total];
        int j = 0;
        int k = 0;
       for (int i = 0 ; i < total ;i++)
       {
        if (j < nums1.length && k < nums2.length)
        {
            if (nums1[j] > nums2[k])
            merged[i] = nums2[k++];
            else merged[i] = nums1[j++];
        }
        else if (j == nums1.length)
        merged[i] = nums2[k++];
        else merged[i] = nums1[j++];
       }

       if (total % 2 == 0)
       return ((double)(merged[total/2 - 1] + merged[total/2]) / 2);
       else return (double)merged[total/2];
    }
}
