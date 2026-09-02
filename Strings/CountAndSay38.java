class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                int count = 1;
                while (j + count < chars.length && chars[j + count] == c) {
                    count++;
                }
                sb.append(count).append(c);
                j += count - 1;
            }
            s = sb.toString();
        }
        return s;
    }
}