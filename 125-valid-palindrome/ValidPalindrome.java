class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder rawStringBuilder = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                rawStringBuilder.append(ch);
            }
        }
        String rawString = rawStringBuilder.toString().toLowerCase();
        int length=rawString.length();
        for(int i=0;i<length/2;i++){
            if(rawString.charAt(i)!=rawString.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }
}
