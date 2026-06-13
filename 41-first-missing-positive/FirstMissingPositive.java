class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int a = nums[i];
                int b = nums[nums[i] - 1];
                nums[i] = b;
                nums[a - 1] = a;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return n + 1;
    }
}