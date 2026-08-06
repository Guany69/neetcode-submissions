class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totProd = 1;
        int zeroCount = 0;
        int indZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0)
            {
                zeroCount++;
                indZero = i;
            }
            else 
            {
                totProd *= nums[i];
            }
           
        }

        int[] out = new int[nums.length];
        if(zeroCount == 1)
        {
          out[indZero] = totProd;
          return out;
        }
        else if(zeroCount>1)
        {
            return out;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0)
            {
            out[i] = totProd/nums[i];
            }
            else
            {
                out[i] = 0;
            }
        }
        return out;
    }
}  
