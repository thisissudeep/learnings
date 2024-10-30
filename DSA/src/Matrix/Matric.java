package Matrix;
import java.util.*;

class Matrix {

    public static  List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return spiral;
        }
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int j = left; j <= right; j++) {
                spiral.add(matrix[top][j]);
            }
            top++;
            
            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;
            
            // Check if there are rows left to traverse
            if (top <= bottom) {
                // Traverse from right to left
                for (int j = right; j >= left; j--) {
                    spiral.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Check if there are columns left to traverse
            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return spiral;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);


        // int m=sc.nextInt(),n=sc.nextInt();
        // int[][] mat=new int[m][n];
        // for(int i=0;i<m;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         mat[i][j]=sc.nextInt();
        //     }
        // }
        // List<Integer> spiralMat=spiralOrder(mat);
        // for(int i=0;i<spiralMat.size();i++)
        //     System.out.print(spiralMat.get(i)+" ");


    }
}
