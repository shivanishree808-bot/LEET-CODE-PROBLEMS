class Solution {
    public String[] findWords(String[] words) {

        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";

        List<String> list = new ArrayList<>();

        for (String word : words) {

            char[] arr = word.toCharArray();

            String row = "";

            if (row1.contains("" + arr[0]))
                row = row1;
            else if (row2.contains("" + arr[0]))
                row = row2;
            else
                row = row3;

            boolean valid = true;

            for (char ch : arr) {
                if (!row.contains("" + ch)) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                list.add(word);
        }

        return list.toArray(new String[0]);
    }
}
