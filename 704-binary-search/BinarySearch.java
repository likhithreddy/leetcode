class Solution {
    int binarySearch(int start, int end, int[] nums, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(start, mid - 1, nums, target);
        } else {
            return binarySearch(mid + 1, end, nums, target);
        }
    }

    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }
}