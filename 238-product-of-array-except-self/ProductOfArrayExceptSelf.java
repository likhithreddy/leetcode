class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] prefixProduct = nums.clone();
        int[] suffixProduct = nums.clone();
        for (int i = 1; i < length; i++) {
            prefixProduct[i] *= prefixProduct[i - 1];
            suffixProduct[length - i - 1] *= suffixProduct[length - i];
        }
        result[0]=suffixProduct[1];
        for(int i=1;i<length-1;i++){
            result[i]=prefixProduct[i-1]*suffixProduct[i+1];
        }
        result[length-1]=prefixProduct[length-2];
        return result;
    }
}