class Solution {
    public int[] plusOne(int[] digits) {
        int pos = digits.length - 1;
        if (digits[pos] != 9) {
            digits[pos] += 1;
        } else {
            while (pos >= 0 && digits[pos] == 9) {
                digits[pos] = 0;
                pos--;
                if (pos < 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    return result;
                }
            }
            digits[pos] += 1;
        }
        return digits;
    }
}