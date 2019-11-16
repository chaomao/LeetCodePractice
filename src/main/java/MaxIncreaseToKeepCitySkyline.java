class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxInRow = new int[grid.length];
        int[] maxInColumn = new int[grid[0].length];

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > maxInRow[i]) maxInRow[i] = grid[i][j];
                if (grid[i][j] > maxInColumn[j]) maxInColumn[j] = grid[i][j];
            }
        }

        for (int i = 0; i < maxInRow.length; i++) {
            for (int j = 0; j < maxInColumn.length; j++) {
                result += Math.min(maxInRow[i], maxInColumn[j]) - grid[i][j];
            }
        }

        return result;
    }
}
