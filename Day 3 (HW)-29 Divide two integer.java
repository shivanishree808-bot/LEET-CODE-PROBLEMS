class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Find the sign of the answer
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to positive long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int answer = 0;

        while (a >= b) {
            a = a - b;
            answer++;
        }

        if (negative) {
            return -answer;
        }

        return answer;
    }
}
