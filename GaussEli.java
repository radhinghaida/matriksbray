import java.io.PrintStream;
import java.util.Scanner;


public class GaussEli {
    public static void GaussEli(double[][] A, double[] B) 
    {   // Matriks A (Koefisien), Matriks B (Hasil dari tiap persamaan)
        int i, j, k, maxIdx, steps, rowPivot;
        double divider, multiplier;

        int totalCol = A.length;
        int totalRow = A[0].length;
        
        // normally, i for column, j for row

        /* 
        int[][] myNumbers = { {1, 2, 3}, {5, 6, 7} };
        int x = myNumbers[1][2]; A[x][y] = x col, y row
        Matrix x is 
        1 2 3
        5 6 7

        A[k][0], k++, to access Row-1 elements
        A[0][k], k++,  to access Column-1 elements
        System.out.println(x); Outputs 7
        */

        steps = 1;

        while (steps <= totalRow) 
        {
            rowPivot = steps-1; 

            for (j = steps-1; j < totalRow; j++) 
            {
                
                if ((j == rowPivot) && (A[j][j] != 1)) // Ketika Row pivot
                {
                    divider = A[j][j];
                    if (divider != 0) {
                        for (i = 0; i < totalCol; i++) { // Supaya Row ke - 1 elemen pertamanya 1
                            A[i][j] = A[i][j] / divider;
                        }
                        B[j] = B[j] / divider;
                    }
                }
            

                if ((j != rowPivot) && (A[steps-1][j] != 0)) // Ketika bukan Row Pivot
                {
                    multiplier = A[steps-1][j];
                    for (i = steps-1; i < totalCol; i++) 
                    {
                        A[i][j] = A[i][j] - (multiplier) * A[i][rowPivot];
                    }
                    B[j] = B[j] - (multiplier) * B[rowPivot];
                }
            } // End of For
            steps++;
        }
    }       
    
}