class Solution {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxWaterArea = 0;
        while (leftIndex < rightIndex) {
            maxWaterArea = Math.max(maxWaterArea,
                    Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex += 1;
            } else {
                rightIndex -= 1;
            }
        }
        return maxWaterArea;
    }
}