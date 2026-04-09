class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> visitedChars = new HashSet<>();
        int leftIndex, rightIndex;
        leftIndex = rightIndex = 0;
        int maxLength = 0;
        while (leftIndex <= rightIndex && rightIndex < s.length()) {
            if (visitedChars.contains(s.charAt(rightIndex))) {
                maxLength = Math.max(maxLength, rightIndex - leftIndex);
                while (leftIndex <= rightIndex && visitedChars.contains(s.charAt(rightIndex))) {
                    visitedChars.remove(s.charAt(leftIndex));
                    leftIndex += 1;
                }
            }
            visitedChars.add(s.charAt(rightIndex));
            rightIndex += 1;
            maxLength = Math.max(maxLength, rightIndex - leftIndex);
        }
        return maxLength;
    }
}