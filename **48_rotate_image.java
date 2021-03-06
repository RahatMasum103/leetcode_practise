You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


class Solution {
    public void rotate(int[][] matrix) {
        
        int dim = matrix.length;
        
        /* Transpose matrix */
        for(int i=0; i<dim; i++) 
        {
            // as n x n matrix, only j starts from i will do the work; can be j=0 too
            for(int j=i; j<dim; j++) 
            {
                int curr_element = matrix[i][j]; //current value into a temporary variable
                matrix[i][j] = matrix[j][i]; //replace row with column
                matrix[j][i] = curr_element; // store the current value
            }
        }
        
        /* Flip columns */
        
        for(int i=0; i<dim; i++)
        {
            // as swaping columns, so half way will be enough; j< dim will work too
            for(int j=0; j<dim/2; j++) 
            { 
                int curr_element = matrix[i][j]; // store current value
                matrix[i][j] = matrix[i][dim-1-j]; //replace columns
                matrix[i][dim-1-j] = curr_element; //restore temp value
            }
        }
        
        return;
        
    }
}
