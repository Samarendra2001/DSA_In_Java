package Valid_Sudoku;

import java.util.HashSet;

public class Solution {
    public static boolean isValidSudoku(char[][] board){
        int N =9;
        //use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for(int r=0;r<N;r++){
            rows[r] = new HashSet<Character>(); // Initialize a hash set for each row.
            cols[r] = new HashSet<Character>() ;// Initialize a hash set for each column.
            boxes[r] = new HashSet<Character>(); // Initialize a hash set for each box.
        }
        for(int r=0;r<N;r++){ // Iterate through all rows.
            for(int c=0;c<N;c++){ // Iterate through all columns of the current row.
                char val = board[r][c]; // Get the value at cell (r, c).

                //check if the position is filled with number
                if(val =='.'){
                    continue;// Skip empty cells.
                }
                //check the row
                if(rows[r].contains(val)){// If the value is already in the current row, Sudoku is invalid.
                    return false;
                }
                rows[r].add(val);// Otherwise, add the value to the current row's set.

                //check the column
                if(cols[r].contains(val)){
                    return false;
                }
                cols[r].add(val);

                //check for the boxes
                int idx = (r/3) *3 + c/3;
                if(boxes[idx].contains(val)){
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }

    public static void main(String[] args) {
            // Create a sample 9x9 Sudoku board
            char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
    
            //Solution solution = new Solution();//for non static
            //boolean isValid = solution.isValidSudoku(board);
            boolean isValid = isValidSudoku(board);//for static
            System.out.println("Is the Sudoku board valid? " + isValid);
    }
}
    

