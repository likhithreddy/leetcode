class Solution {
    void heapify(int[] arr, int n, int i) {
        int leftIdx = 2 * i + 1;
        int rightIdx = 2 * i + 2;
        int largestIdx = i;
        if (leftIdx < n) {
            largestIdx = (arr[leftIdx] > arr[largestIdx]) ? leftIdx : largestIdx;
        }
        if (rightIdx < n) {
            largestIdx = (arr[rightIdx] > arr[largestIdx]) ? rightIdx : largestIdx;
        }
        if (largestIdx != i) {
            int temp = arr[i];
            arr[i] = arr[largestIdx];
            arr[largestIdx] = temp;
            heapify(arr, n, largestIdx);
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
        while (n > 0) {
            int temp = nums[0];
            nums[0] = nums[n - 1];
            nums[n - 1] = temp;
            n -= 1;
            heapify(nums, n, 0);
        }
        return nums;
    }
}