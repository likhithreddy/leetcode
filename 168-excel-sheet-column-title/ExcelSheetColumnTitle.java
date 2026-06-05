class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber -= 1;
            int remainder = columnNumber % 26;
            char ch = (char) (65 + remainder);
            sb.insert(0, ch);
            columnNumber /= 26;
        }
        return sb.toString();
    }
}