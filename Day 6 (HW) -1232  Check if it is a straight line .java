class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;
        boolean digitAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
                if (seenE) {
                    digitAfterE = true;
                }
            } else if (c == '+' || c == '-') {
                // Sign is only valid at the beginning or immediately after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // Dot cannot appear after exponent or more than once
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // Exponent must appear only once and after a digit
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                digitAfterE = false;
            } else {
                return false;
            }
        }

        return seenDigit && digitAfterE;
    }
}
