class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];

        char[] arr = sentence.toCharArray();

        for (char ch : arr) {
            seen[ch - 'a'] = true;
        }

        for (boolean letter : seen) {
            if (!letter) {
                return false;
            }
        }

        return true;
    }
}
