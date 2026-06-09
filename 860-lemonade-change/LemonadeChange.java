class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives, tens;
        fives = tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fives += 1;
            } else if (bill == 10) {
                if (fives == 0) {
                    return false;
                } else {
                    fives -= 1;
                    tens += 1;
                }
            } else {
                if ((fives >= 1 && tens >= 1) || fives >= 3) {
                    if (fives >= 1 && tens >= 1) {
                        fives -= 1;
                        tens -= 1;
                    } else {
                        fives -= 3;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}