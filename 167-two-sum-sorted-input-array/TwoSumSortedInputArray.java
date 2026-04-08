class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int firstNumIndex = 0;
        int secondNumIndex = numbers.length - 1;
        int[] result = new int[2];
        while (firstNumIndex < secondNumIndex) {
            int currentSum = numbers[firstNumIndex] + numbers[secondNumIndex];
            if (currentSum == target) {
                return new int[] { firstNumIndex + 1, secondNumIndex + 1 };
            } else {
                if (currentSum > target) {
                    secondNumIndex -= 1;
                } else {
                    firstNumIndex += 1;
                }

            }
        }
        return null;
    }
}