class Solution {
    public boolean squareIsWhite(String coordinates) {

        char[] arr = coordinates.toCharArray();

        int column = arr[0] - 'a';
        int row = arr[1] - '1';

        return (column + row) % 2 == 1;
    }
}
