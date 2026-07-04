class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] finalOrder = new int[n];
        int[][] tasksDetails = new int[n][3];
        for (int i = 0; i < n; i++) {
            tasksDetails[i][0] = i;
            tasksDetails[i][1] = tasks[i][0];
            tasksDetails[i][2] = tasks[i][1];
        }
        Arrays.sort(tasksDetails, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> availableTasks = new PriorityQueue<int[]>(
                (a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        int time = 0;
        int idx = 0;
        int taskIdx = 0;
        while (idx < n) {
            while (taskIdx < n && tasksDetails[taskIdx][1] <= time) {
                availableTasks.offer(tasksDetails[taskIdx++]);
            }
            if (availableTasks.isEmpty()) {
                time = tasksDetails[taskIdx][1];
                continue;
            }
            int[] bestFit = availableTasks.poll();
            finalOrder[idx++] = bestFit[0];
            time += bestFit[2];
        }
        return finalOrder;
    }
}