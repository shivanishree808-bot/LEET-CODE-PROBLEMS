class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int[] ans = new int[num1.length() + num2.length()];
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {

                int p = (a[i] - '0') * (b[j] - '0');

                p += ans[i + j + 1];

                ans[i + j + 1] = p % 10;
                ans[i + j] += p / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int x : ans) {
            if (!(sb.length() == 0 && x == 0))
                sb.append(x);
        }

        return sb.toString();
    }
}
