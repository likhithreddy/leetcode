class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int volume = 0;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        for (int i = 0; i < length; i++) {
            try {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            } catch (Exception e) {
                leftMax[i] = height[i];
            }
            try {
                rightMax[length - i - 1] = Math.max(rightMax[length - i], height[length - i - 1]);
            } catch (Exception e) {
                rightMax[length - i - 1] = height[length - i - 1];
            }
        }
        for (int i = 0; i < length; i++) {
            int currentVolume = Math.min(leftMax[i], rightMax[i]) - height[i];
            volume += (currentVolume > 0) ? currentVolume : 0;
        }
        return volume;
    }
}