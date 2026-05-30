class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Queue<int[]> queue = new LinkedList<>();
        Map<Character, Integer> uniqueTasks = new HashMap<>();
        int time = 0;
        for (char task : tasks) {
            if (!uniqueTasks.containsKey(task)) {
                uniqueTasks.put(task, 1);
            } else {
                uniqueTasks.put(task, uniqueTasks.get(task) + 1);
            }
        }
        for (Map.Entry<Character, Integer> es : uniqueTasks.entrySet()) {
            maxHeap.offer(new int[] { es.getKey(), es.getValue(), 0 });
        }
        while (!queue.isEmpty() || !maxHeap.isEmpty()) {
            time += 1;
            if (!maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                top[1] -= 1;
                if (top[1] > 0) {
                    queue.offer(new int[] { top[0], top[1], time + n });
                }
            }
            if (!queue.isEmpty() && queue.peek()[2] == time) {
                maxHeap.offer(queue.poll());
            }
        }
        return time;
    }
}