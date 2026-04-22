class Solution {
    public int reverseBits(int n) {
        int[] binaryBits=new int[32];
        for(int i=31;i>=0;i--){
            binaryBits[i]=n%2;
            n/=2;
        }
        int result=0;
        for(int i=0;i<32;i++){
            if(binaryBits[i]==1){
                result+=Math.pow(2,i);
            }
        }
        return result;
    }
}