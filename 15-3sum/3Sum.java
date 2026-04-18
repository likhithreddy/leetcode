class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 2; i++) {
            int firstNum = nums[i];
            int secondNumIndex = i + 1;
            int thirdNumIndex = nums.length - 1;
            while (secondNumIndex < thirdNumIndex && !(i > 0 && firstNum == nums[i - 1])) {
                int secondNum = nums[secondNumIndex];
                int thirdNum = nums[thirdNumIndex];
                int currentSum = firstNum + secondNum + thirdNum;
                if (thirdNumIndex < nums.length - 1 && thirdNum == nums[thirdNumIndex + 1]) {
                    thirdNumIndex -= 1;
                    continue;
                }
                if (currentSum == 0) {
                    result.add(Arrays.asList(firstNum, secondNum, thirdNum));
                    secondNumIndex += 1;
                    thirdNumIndex -= 1;
                } else if (currentSum < 0) {
                    secondNumIndex += 1;
                } else {
                    thirdNumIndex -= 1;
                }
            }
        }
        return result;
    }
}