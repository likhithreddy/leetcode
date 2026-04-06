import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.containsKey(num) ? hm.get(num) + 1 : 1);
        }
        Map<Integer, List<Integer>> ihm = new HashMap<>();
        for (Map.Entry<Integer, Integer> entrySet : hm.entrySet()) {
            if (!ihm.containsKey(entrySet.getValue())) {
                ihm.put(entrySet.getValue(), new ArrayList<>());
            }
            ihm.get(entrySet.getValue()).add(entrySet.getKey());
        }
        int[] result = new int[k];
        int idx = 0;
        for (int i = nums.length; i >= 1 && idx < k; i--) {
            if (ihm.containsKey(i)) {
                for (int num : ihm.get(i)) {
                    result[idx++] = num;
                    if (idx == k) break;
                }
            }
        }
        return result;
    }
}