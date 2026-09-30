package List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        // Create a DP array to store the minimum path sum to each cell
        int[][] dp = new int[n][n];

        // Initialize the top of the triangle
        dp[0][0] = triangle.get(0).get(0);

        // Fill the DP array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // Only one way to reach the leftmost element
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    // Only one way to reach the rightmost element
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    // Take the minimum path from the two possible paths above
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }

        // Find the minimum path sum in the last row of the DP array
        int minTotal = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minTotal = Math.min(minTotal, dp[n - 1][j]);
        }

        return minTotal;
    }
}
