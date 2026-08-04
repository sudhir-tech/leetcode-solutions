package Math;

public class DivideTwoIntegers29 { 
    public int divide(int dividend, int divisor) {
        // Handle edge cases
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow case
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to positive
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        long quotient = 0;

        while (ldividend >= ldivisor) {
            long temp = ldivisor, multiple = 1;
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            ldividend -= temp;
            quotient += multiple;
        }

        return negative ? -(int) quotient : (int) quotient;
    }
    
}
