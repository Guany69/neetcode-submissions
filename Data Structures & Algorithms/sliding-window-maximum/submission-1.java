//imagine we have a array of ints from 0 - k-1
//we can find some max int in that array
// now imagine we get rid of that first integer and add a new number to the end
//We can take the greatest from the previous array if it was not the first integer in the array and compare it to the new number and that will be the max of that array
//if the first index is the biggest then the 2nd greatest value in the array can be compared to the new value
//now if we have window size k & array size n
//we would start 0-(k-1)
//all down to k - (n - 1)
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int[] solution = new int[((len) - (k - 1))];
        int[] largest = {-1,-1};
        while(right < len){
            int i1 = largest[0];
            int i2 = largest[1];
            
            if(i1 != -1 && i2 != -1){
                if(nums[right] >= nums[i1]){
                    int temp = largest[0];
                    largest[0] = right;
                    largest[1] = temp;
                } else if(nums[right] >= nums[i2]){
                        largest[1] = right;
                    }
            } else if(i1 == -1) {
                largest[0] = right; 
            } else {
                if(nums[right] >= nums[i1]){
                    int temp = largest[0];
                    largest[0] = right;
                    largest[1] = temp;
                } else{
                    largest[1] = right;
                }
            }

            if(right == left + (k - 1)){
                int iMax = largest[0];
                int i2Max = largest[1];
                solution[left] = nums[iMax];
                if(iMax == left){
                    largest[0] = largest[1];
                    largest[1] = -1;
                } else if(i2Max == left){
                    largest[1] = -1;
                }
                left++;
            }

            right++;
        }
        return solution;
    }
}
