class TimeMap {
    private Map<String, List<int[]>> timeMap;
    private Map<String, List<String>> valueMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>())
                .add(new int[] { timestamp });
        valueMap.computeIfAbsent(key, k -> new ArrayList<>())
                .add(value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";

        List<int[]> times = timeMap.get(key);
        int low = 0, high = times.size() - 1, idx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (times.get(mid)[0] <= timestamp) {
                idx = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return idx == -1 ? "" : valueMap.get(key).get(idx);
    }
}