class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> visitedChars = new HashMap<>();
        int leftIndex, rightIndex;
        leftIndex = rightIndex = 0;
        int maxLength = 0;
        while (leftIndex <= rightIndex && rightIndex < s.length()) {
            if (visitedChars.containsKey(s.charAt(rightIndex))) {
                maxLength = Math.max(maxLength, rightIndex - leftIndex);
                leftIndex = Math.max(leftIndex, visitedChars.get(s.charAt(rightIndex)) + 1);
            }
            visitedChars.put(s.charAt(rightIndex), rightIndex);
            rightIndex += 1;
            maxLength = Math.max(maxLength, rightIndex - leftIndex);
        }
        return maxLength;
    }
}