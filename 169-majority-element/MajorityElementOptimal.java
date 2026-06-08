class Solution {
    public int majorityElement(int[] nums) {
        int count, candidate;
        count = candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count += 1;
            } else {
                if (num == candidate) {
                    count += 1;
                } else {
                    count -= 1;
                }
            }
        }
        return candidate;
    }
}