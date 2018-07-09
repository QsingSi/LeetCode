class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0, j = 0.k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                nums3[k] = nums1[i];
                i++;
                k++;
            } else {
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }
        if (i < nums1.length) {
            for (; i < nums1.length; i++)
                nums3[k++] = nums1[i];
        }
        if (j < nums2.length) {
            for (; j < nums2.length; j++)
                nums3[k++] = nums2[j];
        }
        if (k % 2 != 0)
            return nums3[k / 2];
        else return (nums3[k / 2] + nums3[k / 2 - 1]) / 2.0;
    }
}
