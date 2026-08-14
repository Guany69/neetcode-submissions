class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n < 3) {
            return 0;
        } // if our length is less than 3 than we have 0
        //only 2 bars can't make a space

        int tallest = 0;

        for (int i = 1; i < n; i++) {
            if (height[i] > height[tallest]) {
                tallest = i;
            }
        }// index of tallest bar

        int totalWater = 0;

        // Process basins to the left of the tallest bar
        int left = 0;
        int midSum = 0;

    //iterate from left to right before tallest block
        for (int right = 1; right <= tallest; right++) {
            if (height[right] >= height[left]) {
                int spaces = right - left - 1; //empty spaces
                
            // amount of capacity before our right side gets equal or bigger to left side
                int capacity = spaces * height[left]; 

                totalWater += capacity - midSum;// capacity subtracted by midSum

                left = right;//set left to new side
                midSum = 0;
            } else {
                midSum += height[right];//add to md
            }
        }

        // Process basins to the right of the tallest bar
        int right = n - 1;
        midSum = 0;

        for (left = n - 2; left >= tallest; left--) {
            if (height[left] >= height[right]) {
                int spaces = right - left - 1;
                int capacity = spaces * height[right];

                totalWater += capacity - midSum;

                right = left;
                midSum = 0;
            } else {
                midSum += height[left];
            }
        }

        return totalWater;
    }
}