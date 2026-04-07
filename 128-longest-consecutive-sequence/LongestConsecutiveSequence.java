class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        int result = 0;
        for (int num:hs) {
            int currentLength = 1;
            int currentNum = num;
            if (!hs.contains(currentNum - 1)) {
                while (hs.contains(currentNum + 1)) {
                    currentLength += 1;
                    currentNum += 1;
                }
                result = (currentLength > result) ? currentLength : result;
            }
        }
        return result;
    }
}