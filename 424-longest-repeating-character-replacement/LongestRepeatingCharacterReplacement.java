class Solution {
    public int characterReplacement(String s, int k) {
        int[] visitedChars = new int[26];
        int start, end, maxWindowLength;
        start = end = maxWindowLength = 0;
        while (start <= end && end < s.length()) {
            visitedChars[s.charAt(end) - 'A'] += 1;
            int maxCount = 0;
            for (int charCount : visitedChars) {
                maxCount = (charCount > maxCount) ? charCount : maxCount;
            }
            end += 1;
            if (end - start - maxCount > k) {
                visitedChars[s.charAt(start) - 'A'] -= 1;
                start += 1;
            }
            maxWindowLength = (end - start > maxWindowLength) ? end - start : maxWindowLength;
        }
        return maxWindowLength;
    }
}
