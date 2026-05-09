class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() > 1) {
            int stoneOne = heap.poll();
            int stoneTwo = heap.poll();
            if (stoneOne != stoneTwo) {
                heap.offer(stoneOne - stoneTwo);
            }
        }
        return (heap.size() == 0) ? 0 : heap.poll();
    }
}