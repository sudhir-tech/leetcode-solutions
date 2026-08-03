package Strings;

public class LongestSubstringWithoutRepeatingChars03 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        boolean[] seen = new boolean[128]; // Assuming ASCII characters

        while (right < n) {
            char currentChar = s.charAt(right);
            if (!seen[currentChar]) {
                seen[currentChar] = true;
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                seen[s.charAt(left)] = false;
                left++;
            }
        }

        return maxLength;
    }
}
