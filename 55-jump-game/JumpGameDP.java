class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int j = nums.length - 2; j >= 0; j--) {
            for (int i = 1; i <= nums[j]; i++) {
                if (dp[i + j]) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}