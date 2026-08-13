package Strings;

public class PermutationSequence60 {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        k--; // Convert to zero-based index

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            k %= factorial[n - i];

            for (int j = 1; j <= n; j++) {
                if (!used[j]) {
                    if (index == 0) {
                        sb.append(j);
                        used[j] = true;
                        break;
                    }
                    index--;
                }
            }
        }

        return sb.toString();
    }
    
}
