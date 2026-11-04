class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length*matrix[0].length) - 1;
        int mid = (high + low) / 2;
        while(low <= high){
            int r = (mid)/(matrix[0].length);
            int c = (mid)%(matrix[0].length);
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
            mid = (high + low) / 2;
        }
        return false;
    }
}
