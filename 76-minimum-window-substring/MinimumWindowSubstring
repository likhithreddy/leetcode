class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        int right = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (need[c]-- > 0) {
                formed++;
            }
            while (formed == t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                if (need[s.charAt(left++)]++ == 0) {
                    formed--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}