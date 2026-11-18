class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right + left)/2;
        while(left < right){
            if(nums[mid] == target){
                break;
            }
            if(nums[mid] < target){
                if(nums[left] < nums[mid]){
                    left = mid + 1;
                } else {
                    if(nums[right] < target){
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                if(nums[right] > nums[mid] || nums[right] < target){
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            mid = (right + left) / 2;
        }
        if(nums[mid] == target){
            return mid;
        }
        return -1;
    }
}
