class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start<end && !Character.isLetterOrDigit(s.charAt(start))) {
                start += 1;
            }
            while (start<end && !Character.isLetterOrDigit(s.charAt(end))) {
                end -= 1;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            } else {
                start += 1;
                end -= 1;
            }
        }
        return true;
    }
}
