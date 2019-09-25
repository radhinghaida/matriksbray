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
        for (i = 0; i < M.length; i ++) {
            for (j = 0; j < M[0].length; j++) {
                MI[i][j] = MA[i][j]*(1/detM);
            }
        }
    return MI;
    }

    public static void GaussEliInverse(double[][] A,double[][] MI) 
    {   // Matriks A (Koefisien), Matriks B (Hasil dari tiap persamaan)
        int i, j, k, steps, rowPivot;
        double divider, multiplier;

        int totalCol = A.length;
        int totalRow = A[0].length;
        
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A[0].length; j++) {
                if (i == j) {
                    MI[i][j] = 1;
                }
                else {
                    MI[i][j] = 0;
                }
            }
        }

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
                        SwapRowInverse(MI, j, j+1);
                    }
                }                

                if ((j == rowPivot) && (A[j][j] != 1)) // Ketika Row pivot
                {
                    divider = A[j][j];
                    if (divider != 0) {
                        for (i = 0; i < totalCol; i++) { // Supaya Row ke - 1 elemen pertamanya 1
                            A[i][j] = A[i][j] / divider;
                            MI[i][j] = MI[i][j] / divider;
                        }
                    }
                }
            

                if ((j != rowPivot) && (A[steps-1][j] != 0)) // Ketika bukan Row Pivot
                {
                    multiplier = A[steps-1][j];
                    for (i = steps-1; i < totalCol; i++) 
                    {
                        A[i][j] = A[i][j] - (multiplier) * A[i][rowPivot];
                        MI[i][j] = MI[i][j] - (multiplier) * MI[i][rowPivot];
                    }
                }
            } // End of For
            steps++;
        }
    } // End of GaussEliInverse    
    


    public static double[][] InverseGaussJordan(double[][] A) {
        double[][] MI = new double[A.length][A[0].length]; // Menyimpan matriks Inverse hasil
        
        GaussEliInverse(A, MI);

        steps = totalRow;

        while (steps > 0) {
            rowPivot = steps-1;
            for (j = rowPivot-1; j >= 0; j--) {
                if (!(isAllZero(A, j))) {
                    if (A[rowPivot][j] != 0) {
                        multiplier = A[steps-1][j];
                        A[rowPivot][j] -= (multiplier);
                        MI[rowpivot][j] -= (multiplier);
                    }
                }
            } // End of For
            steps--;
        } // End of While
        return MI;
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
