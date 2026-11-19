class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int median = (nums1.length + nums2.length + 1) / 2;
        int l1 = 0;
        int r1 = nums1.length - 1;
        int l2 = 0;
        int r2 = nums2.length - 1;
        int m1 = 0;
        int m2 = 0;
        int cur = 0;
        int grtr = 0;

        if(nums1.length == 0){
            if(nums2.length % 2 == 0){
                int len = nums2.length - 1;
                int mid = len/2;
                return (double)(nums2[mid] + nums2[mid + 1]) / 2;
            } else{
                return (double)nums2[nums2.length/2];
            }
        } else if(nums2.length == 0){
            if(nums1.length % 2 == 0){
                int len = nums1.length - 1;
                int mid = len/2;
                return (double)(nums1[mid] + nums1[mid + 1]) / 2;
            } else{
                return (double)nums1[nums1.length/2];
            }
        }
       while(l1 <= r1){
            m1 = (l1 + r1) / 2;
            grtr = binarySearch(nums2, l2, r2, nums1[m1], median - m1);
            cur = m1;
            if((cur + grtr) == (median - 1)){
                return returnMedian(nums1, nums2, cur, grtr);
            } else if((cur + grtr) > (median - 1)) {
                r1 = m1 - 1;
            } else {
                l1 = m1 + 1;
            }
        }

        if((cur + grtr) > (median - 1)){
            r2 = grtr;
        } else {
            l2 = grtr;
        }

        while(l2 <= r2){
            m2 = (r2 + l2) / 2;
            grtr = binarySearch(nums1, 0, nums1.length - 1, nums2[m2], median - m2);
            cur = m2;
            if((cur + grtr) == (median - 1)){
                return returnMedian(nums2, nums1, cur, grtr);
            } else if((cur + grtr) > (median - 1)) {
                r2 = m2 - 1;
            } else {
                l2 = m2 + 1;
            }
        }

        return cur;
    }

    public double returnMedian(int num1[], int num2[], int cur, int grtr){
        boolean even = isEven(num1.length + num2.length);
        double median = 0;
        if(even){
            double nxtgrtr = num1[cur];
            if(cur < (num1.length - 1) && grtr < (num2.length)) {
                nxtgrtr += Math.min(num1[cur + 1], num2[grtr]);
            } else if(grtr < (num2.length)){
                nxtgrtr += num2[grtr];
            } else {
                nxtgrtr+= num1[cur + 1];
            }
            median = nxtgrtr / 2;
        } else {
            median = num1[cur];
        }
        return median;
    }
    public boolean isEven(int num){
        if(num % 2 == 0){
            return true;
        }
        return false;
    }

    public int binarySearch(int[] nums, int left, int right, int target, int thresh){
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target){
                    left = mid + 1;
                    while(left > thresh){
                        if(nums[left] == target){
                            left--;
                        } else{
                            break;
                        }
                    }
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        } 
}