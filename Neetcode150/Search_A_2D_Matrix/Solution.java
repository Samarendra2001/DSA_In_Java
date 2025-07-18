package Search_A_2D_Matrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // Dimensions of the matrix
        int m = matrix.length;      // Number of rows
        int n = matrix[0].length;   // Number of columns matrix[0] refers to the first row of the matrix, i.e., an array that holds the elements of the first row.
        
        int left = 0;
        int right = m * n - 1; // Treat as a 1D array

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;   // Avoid overflow with (left + right) / 2
            int midValue = matrix[mid / n][mid % n]; // Map mid to 2D position.. it will give you indexes of mid value and mid value
            
            // Check if midValue matches the target
            if (midValue == target) {
                return true;
            }
            // Adjust search boundaries
            else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Target not found
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example Matrix
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        // Example Target
        int target = 16;

        // Search and Print Result
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Is the target present? " + result);
    }
}
