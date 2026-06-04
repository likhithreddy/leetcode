class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] trustMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < trust.length; i++) {
            int trustee = trust[i][0];
            int truster = trust[i][1];
            trustMatrix[trustee][truster] = 1;
        }
        for (int col = 1; col <= n; col++) {
            int trustCount = 0;
            for (int row = 1; row <= n; row++) {
                if (trustMatrix[row][col] == 1) {
                    trustCount += 1;
                }
            }
            if (trustCount == n - 1) {
                for (int c = 1; c <= n; c++) {
                    if (trustMatrix[col][c] == 1) {
                        return -1;
                    }
                }
                return col;
            }
        }
        return -1;
    }
}