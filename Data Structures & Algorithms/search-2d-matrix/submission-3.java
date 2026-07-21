class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while(end >= start){
            int mid = start + (end - start) / 2;

            int value = matrix[mid/cols][mid % cols];

            if(value == target){
                return true;
            }else if(value < target){
                start = mid + 1;
            }else{
                end  = mid - 1;
            }
        }
        return false;
    }
}

