class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alienAlphabets = new int[26];
        for (int i = 0; i < 26; i++) {
            alienAlphabets[order.charAt(i) - 'a'] = i;
        }
        int idx = 0;
        while (idx + 1 < words.length) {
            String wordOne = words[idx];
            String wordTwo = words[idx + 1];
            int stringIdx = 0;
            while (stringIdx < wordOne.length() && stringIdx < wordTwo.length()) {
                if (alienAlphabets[wordOne.charAt(stringIdx) - 'a'] > alienAlphabets[wordTwo.charAt(stringIdx) - 'a']) {
                    return false;
                } else if (alienAlphabets[wordOne.charAt(stringIdx) - 'a'] < alienAlphabets[wordTwo.charAt(stringIdx)
                        - 'a']) {
                    break;
                }
                stringIdx += 1;
            }
            if (wordOne.length() > wordTwo.length() && stringIdx == wordTwo.length()) {
                return false;
            }
            idx += 1;
        }
        return true;
    }
}