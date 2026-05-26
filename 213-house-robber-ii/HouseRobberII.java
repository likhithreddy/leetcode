class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return (n == 1) ? nums[0] : Math.max(nums[0], nums[1]);
        }
        return Math.max(robOption(nums, 0, n - 2), robOption(nums, 1, n - 1));
    }

    int robOption(int[] nums, int first, int last) {
        int prev1, prev2;
        prev1 = prev2 = 0;
        for (int i = first; i <= last; i++) {
            int current = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}