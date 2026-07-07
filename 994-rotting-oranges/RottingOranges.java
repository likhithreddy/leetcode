class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[] { row, col });
                } else if (grid[row][col] == 1) {
                    freshOranges += 1;
                }
            }
        }

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            boolean hasRottenSomething = false;

            for (int i = 0; i < size; i++) {
                int[] croIdx = queue.poll();
                if (croIdx[0] > 0 && grid[croIdx[0] - 1][croIdx[1]] == 1) {
                    grid[croIdx[0] - 1][croIdx[1]] = 2;
                    queue.add(new int[] { croIdx[0] - 1, croIdx[1] });
                    hasRottenSomething = true;
                    freshOranges -= 1;
                }
                if (croIdx[1] > 0 && grid[croIdx[0]][croIdx[1] - 1] == 1) {
                    grid[croIdx[0]][croIdx[1] - 1] = 2;
                    queue.add(new int[] { croIdx[0], croIdx[1] - 1 });
                    hasRottenSomething = true;
                    freshOranges -= 1;
                }
                if (croIdx[0] < rows - 1 && grid[croIdx[0] + 1][croIdx[1]] == 1) {
                    grid[croIdx[0] + 1][croIdx[1]] = 2;
                    queue.add(new int[] { croIdx[0] + 1, croIdx[1] });
                    hasRottenSomething = true;
                    freshOranges -= 1;
                }
                if (croIdx[1] < cols - 1 && grid[croIdx[0]][croIdx[1] + 1] == 1) {
                    grid[croIdx[0]][croIdx[1] + 1] = 2;
                    queue.add(new int[] { croIdx[0], croIdx[1] + 1 });
                    hasRottenSomething = true;
                    freshOranges -= 1;
                }
            }

            if (hasRottenSomething) {
                minutes += 1;
            }
        }

        return freshOranges > 0 ? -1 : minutes;
    }
}