class Point {
    int x;
    int y;
    double distance;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));
        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);
            minHeap.offer(p);
        }
        List<int[]> result = new ArrayList<>();
        while (k-- > 0) {
            Point p = minHeap.poll();
            result.add(new int[] { p.x, p.y });
        }
        return result.toArray(new int[0][]);
    }
}