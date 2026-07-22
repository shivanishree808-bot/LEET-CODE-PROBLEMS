class Solution {
    public List<String> commonChars(String[] words) {

        int[] minFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            minFreq[i] = Integer.MAX_VALUE;
        }

        for (String word : words) {

            int[] freq = new int[26];
            char[] arr = word.toCharArray();

            for (char ch : arr) {
                freq[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {

            while (minFreq[i] > 0) {
                ans.add("" + (char)(i + 'a'));
                minFreq[i]--;
            }
        }

        return ans;
    }
}
