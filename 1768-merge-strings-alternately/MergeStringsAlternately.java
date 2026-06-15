class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        sb.append((len1 > minLen) ? word1.substring(minLen, len1) : word2.substring(minLen, len2));
        return sb.toString();
    }
}