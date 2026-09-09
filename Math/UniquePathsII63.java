package Math;

public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting cell has an obstacle, return 0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Create a 2D array to store the number of unique paths to each cell
        int[][] dp = new int[m][n];
        dp[0][0] = 1; // Starting point

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
        }

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 1) ? 0 : dp[0][j - 1];
        }

        // Fill the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // If there's an obstacle, no paths lead to this cell
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from top and left cells
                }
            }
        }

        // The bottom-right cell contains the total number of unique paths
        return dp[m - 1][n - 1];
    }
}
