class Solution {
    public String reorganizeString(String s) {
        int[] alphaCount = new int[26];
        for (char ch : s.toCharArray()) {
            alphaCount[ch - 'a'] += 1;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < 26; i++) {
            if (alphaCount[i] > 0) {
                maxHeap.offer(new int[] { i, alphaCount[i] });
            }
        }
        if (maxHeap.peek()[1] > (s.length() + 1) / 2) {
            return "";
        }
        char[] result = new char[s.length()];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            int[] currentAlpha = maxHeap.poll();
            while (currentAlpha[1]-- > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                result[idx] = (char) (currentAlpha[0] + 'a');
                idx += 2;
            }
        }
        return new String(result);
    }
}