class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> hm = new HashMap<>();
        for(char c:s.toCharArray()){
            hm.put(c,hm.containsKey(c)?(hm.get(c)+1):1);
        }
        for(char c:t.toCharArray()){
            if(!(hm.containsKey(c))){
                return false;
            }
            else{
                if(hm.get(c)==1){
                    hm.remove(c);
                }
                else{
                    hm.put(c,hm.get(c)-1);
                }
            }
        }
        return hm.isEmpty()?true:false;        
    }
}