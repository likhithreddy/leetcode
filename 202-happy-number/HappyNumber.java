class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();

        while (n != 1) {
            if (!hs.add(n)) {
                return false;
            }
            n = getSumOfSquares(n);
        }
        return true;
    }

    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}