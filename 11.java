class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int tmpH = height[left] < height[right] ? height[left] : height[right];
            int width = right - left;
            if (tmpH * width > maxArea) {
                maxArea = tmpH * width;
            }
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}