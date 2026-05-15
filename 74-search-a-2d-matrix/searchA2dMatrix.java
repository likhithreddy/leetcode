class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int c = columns - 1;
        int r = 0;
        while (r < rows && c >= 0) {
            int currentNum = matrix[r][c];
            if (currentNum == target) {
                return true;
            } else if (currentNum < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}