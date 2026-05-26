class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            maxHeap.offer(new int[] { point[0], point[1], distance });
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<int[]> result = new ArrayList<>();
        while (k-- > 0) {
            int[] p = maxHeap.poll();
            result.add(new int[] { p[0], p[1] });
        }
        return result.toArray(new int[0][]);
    }
}