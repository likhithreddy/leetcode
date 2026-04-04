class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> hm = new HashMap<>();
        for (String str : strs) {
            int[] alphabetCount = new int[26];
            for (char c : str.toCharArray()) {
                alphabetCount[c - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder("");
            for (int idx = 0; idx < 26; idx++) {
                sb.append((char) (idx + 'a'));
                sb.append(alphabetCount[idx]);
            }
            String anagramSchema = sb.toString();
            if (!hm.containsKey(anagramSchema)) {
                hm.put(anagramSchema, new ArrayList<>());
            }
            hm.get(anagramSchema).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}