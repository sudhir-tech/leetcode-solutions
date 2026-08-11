public class DecodeWays91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0; // No valid decoding for empty string or string starting with '0'
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one way to decode
        dp[1] = 1; // Base case: single character (not '0') has one way to decode

        for (int i = 2; i <= n; i++) {
            char currentChar = s.charAt(i - 1);
            char previousChar = s.charAt(i - 2);

            // Check if the current character can be decoded on its own
            if (currentChar != '0') {
                dp[i] += dp[i - 1];
            }

            // Check if the last two characters can be decoded together
            int twoDigitNumber = (previousChar - '0') * 10 + (currentChar - '0');
            if (twoDigitNumber >= 10 && twoDigitNumber <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n]; // The total number of ways to decode the entire string
    }
}
