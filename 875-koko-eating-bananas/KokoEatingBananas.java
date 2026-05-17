class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for (int pile : piles) {
            maxSpeed = (pile > maxSpeed) ? pile : maxSpeed;
        }
        while (minSpeed < maxSpeed) {
            int mid = (minSpeed + maxSpeed) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }
}