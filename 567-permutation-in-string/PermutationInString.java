class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            hm.put(ch, (hm.containsKey(ch)) ? (hm.get(ch) + 1) : 1);
        }
        int left, right;
        left = right = 0;
        while (right < s2.length()) {
            if (right - left == s1.length()) {
                return true;
            }
            if (!hm.containsKey(s2.charAt(right))) {
                for (int i = left; i < right; i++) {
                    if (hm.containsKey(s2.charAt(i))) {
                        hm.put(s2.charAt(i), hm.get(s2.charAt(i)) + 1);
                    }
                }
                left = right + 1;
                right = left;
            } else {
                hm.put(s2.charAt(right), hm.get(s2.charAt(right)) - 1);
                while (hm.get(s2.charAt(right)) < 0) {
                    hm.put(s2.charAt(left), hm.get(s2.charAt(left)) + 1);
                    left += 1;
                }
                right += 1;
            }
        }
        return (right - left == s1.length()) ? true : false;
    }
}