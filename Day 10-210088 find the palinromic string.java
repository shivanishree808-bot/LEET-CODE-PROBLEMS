class Solution {
    public String firstPalindrome(String[] words) {

        for (String word : words) {

            char[] arr = word.toCharArray();

            int left = 0;
            int right = arr.length - 1;

            boolean palindrome = true;

            while (left < right) {

                if (arr[left] != arr[right]) {
                    palindrome = false;
                    break;
                }

                left++;
                right--;
            }

            if (palindrome) {
                return word;
            }
        }

        return "";
    }
}
