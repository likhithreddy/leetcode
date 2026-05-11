class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int idx = 0; idx < temperatures.length; idx++) {
            while ((!stack.isEmpty()) && (temperatures[stack.peek()] < temperatures[idx])) {
                int poppedIdx = stack.pop();
                result[poppedIdx] = idx - poppedIdx;
            }
            stack.push(idx);
        }
        return result;
    }
}