class Solution {
    Map<Character,Integer> encodeMap = new HashMap<>();
    Map<Integer,Character> decodeMap = new HashMap<>();
    void encodeDecode(){
        for(int i=0; i<256; i++){
                encodeMap.put((char)i,i);
                decodeMap.put(i,(char)i);
        }
        // for(Map.Entry<Character,Integer> entrySet:encodeMap.entrySet()){
        //     System.out.println(entrySet.getKey()+":"+entrySet.getValue());
        // }
    }

    public String encode(List<String> strs) {
        encodeDecode();
        StringBuilder sb = new StringBuilder("");
        for(String str:strs){
            for(char c: str.toCharArray()){
                sb.append(encodeMap.get(c));
                sb.append(".");
            }
        sb.append("#");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        encodeDecode();
        List<String> result = new ArrayList<>();
        int length=str.length();
        int index=0;
        StringBuilder letterBuilder = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder("");
        while(index < length){
            if(str.charAt(index) == '.'){
                wordBuilder.append(decodeMap.get(Integer.parseInt(letterBuilder.toString())));
                letterBuilder.setLength(0);
            } else if(str.charAt(index) == '#'){
                result.add(wordBuilder.toString());
                wordBuilder.setLength(0);
            } else {
                letterBuilder.append(str.charAt(index));
            }
            index+=1;
        }
        return result;
    }
}
