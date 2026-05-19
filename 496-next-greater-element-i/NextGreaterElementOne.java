class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int lengthOne = nums1.length;
        int lengthTwo = nums2.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[lengthOne];
        for (int i = lengthTwo - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            hm.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < lengthOne; i++) {
            result[i] = hm.get(nums1[i]);
        }
        return result;
    }
}