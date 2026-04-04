class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int idx=0;
        while (idx < nums.length) {
            int remaining = target - nums[idx];
            if (hm.containsKey(remaining)) {
                return new int[]{idx,hm.get(remaining)};
            }
            hm.put(nums[idx], idx);
            idx+=1;
        }
        return null;
    }
}