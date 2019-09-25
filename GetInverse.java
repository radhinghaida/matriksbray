public class GetInverse {

    static double[][] adjoinInverse(double[][]M) {
        double[][] MA = new double[M.length][M[0].length]; // Menyimpan matriks Adjoin
        double[][] MI = new double[M.length][M[0].length]; // Menyimpan matriks Inverse hasil
        double detM; // Menyimpan hasil determinan matriks M
        int i, j;
        GetCofactor myCofactor = new GetCofactor();
        GetDeterminant myDet = new GetDeterminant();
        MA = myCofactor.makeAdjMatrix(M);
        detM = myDet.cofDeterminant(M);
        for (i = 0; i < M[0].length; i ++) {
            for (j = 0; j < M.length; j++) {
                MI[j][i] = MA[j][i]*(1/detM);
            }
        }
    return MI;
    }

    public static void GaussEliInverse(double[][] A, double[] B) 
    {   // Matriks A (Koefisien), Matriks B (Hasil dari tiap persamaan)
        int i, j, k, steps, rowPivot;
        double divider, multiplier;

        int totalCol = A.length;
        int totalRow = A[0].length;

        double[][] MI = new double[M.length][M[0].length]; // Menyimpan matriks Inverse hasil
        
        // normally, i for column, j for row

        /* 
        int[][] myNumbers = { {1, 2, 3}, {5, 6, 7} };
        int x = myNumbers[1][2]; A[x][y] = x col, y row
        Matrix x is 
        1 5 
        2 6
        3 7

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
                // Checking if Row contains all zero or not
                if (isAllZero(A, j)) {
                    if (j + 1 < totalRow) {
                        SwapRowInverse(A, j, j+1);
                        SwapElInverse(B, j, j+1);
                    }
                }                

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
    } // End of GaussEliInverse    
    


    public static void InverseGaussJordan(double[][] A, double[] B) {
        int i, j, k, steps, rowPivot;
        double divider, multiplier;

        int totalCol = A.length;
        int totalRow = A[0].length;
        GaussEliInverse(A,B);

        steps = totalRow;

        while (steps > 0) {
            rowPivot = steps-1;
            for (j = rowPivot-1; j >= 0; j--) {
                if (!(isAllZero(A, j))) {
                    if (A[rowPivot][j] != 0) {
                        multiplier = A[steps-1][j];
                        A[rowPivot][j] -= (multiplier);
                        B[j] -= (multiplier) * B[rowPivot];
                    }
                }
            } // End of For
            steps--;
        } // End of While

    }



    static void SwapRowInverse(double[][] A, int row1, int row2) {
        int i, colLength;
        double temp;
        colLength = A.length;
        for (i = 0; i < colLength; i++) {
            temp = A[i][row1];
            A[i][row1] = A[i][row2];
            A[i][row2] = temp;
        }

    } // End of SwapRow

    static void SwapColInverse(double[][] A, int col1, int col2) {
        double[] temp;
        temp = A[col1];
        A[col1] = A[col2];
        A[col2] = temp;
    } // End of SwapCol

    static void SwapElInverse(double[] B, int row1, int row2) {
        double temp;
        temp = B[row1];
        B[row1] = B[row2];
        B[row2] = temp;
    } // End of SwapEl

    static boolean isAllZero(double[][] A, int row) {
        int i, colLength;
        colLength = A.length;
        boolean allZero = true;
        for (i = 0; i < colLength; i++) {
            if (A[i][row] != 0) {
                allZero = false;
            }
        }
        return allZero;
    } // End of isAllZero

}
