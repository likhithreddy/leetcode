class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start, end;
        start = end = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        while (true) {
            if (sum < target && end < nums.length) {
                sum += nums[end];
                end += 1;
            } else if (sum >= target) {
                minSize = Math.min(minSize, end - start);
                sum -= nums[start];
                start += 1;
            } else {
                return minSize == Integer.MAX_VALUE ? 0 : minSize;
            }
        }
    }
}