class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for(char c:s.toCharArray()){
            alphabets[c-'a']+=1;
        }
        for(char c:t.toCharArray()){
            alphabets[c-'a']-=1;
        }
        int alphabetIndex=0;
        while(alphabetIndex<26){
            if(alphabets[alphabetIndex]!=0){
                return false;
            }
            alphabetIndex+=1;
        }
        return true;
    }
}