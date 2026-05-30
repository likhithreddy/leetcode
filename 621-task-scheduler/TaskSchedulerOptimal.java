class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        int maxFrequency = 0;
        for (char task : tasks) {
            frequencies[task - 'A'] += 1;
            maxFrequency = (frequencies[task - 'A'] > maxFrequency) ? frequencies[task - 'A'] : maxFrequency;
        }
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            if (frequencies[i] == maxFrequency) {
                maxCount += 1;
            }
        }
        return Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxCount);
    }
}