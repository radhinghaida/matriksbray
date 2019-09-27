import java.io.PrintStream;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class GaussEli {

    private static DecimalFormat df3 = new DecimalFormat("#.###");

    public static void GaussEli(double[][] A, double[] B) 
    {   // Matriks A (Koefisien), Matriks B (Hasil dari tiap persamaan)
        int i, j, k, steps, rowPivot;
        double divider, multiplier;

        int totalCol = A.length;
        int totalRow = A[0].length;
        
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
                        SwapRow(A, j, j+1);
                        SwapEl(B, j, j+1);
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
    } // End of GaussEli       
    


    public static void GaussJordan(double[][] A, double[] B) {
        int i, j, k, steps, rowPivot;
        double divider, multiplier;
        int totalCol = A.length;
        int totalRow = A[0].length;
        GaussEli(A,B);

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

    static double[][] CopyMatriks(double[][] M){
        double[][] MCopy = new double[M.length][M[0].length];
        for(int j=0;j<M[0].length;j++){
            for(int i=0;i<M.length;i++){
                MCopy[i][j] = M[i][j];
            }
        }
        return MCopy;
    }

    static void SwapRow(double[][] A, int row1, int row2) {
        int i, colLength;
        double temp;
        colLength = A.length;
        for (i = 0; i < colLength; i++) {
            temp = A[i][row1];
            A[i][row1] = A[i][row2];
            A[i][row2] = temp;
        }

    } // End of SwapRow

    static void SwapCol(double[][] A, int col1, int col2) {
        double[] temp;
        temp = A[col1];
        A[col1] = A[col2];
        A[col2] = temp;
    } // End of SwapCol

    static void SwapEl(double[] B, int row1, int row2) {
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

    static void solveSPL(double[][] A, double[] B) { // Masih bermasalah kalo ada free variable
        int i, j, k, l, totalFreeVar, totalRow, initialASCII, loop;
        double tempConstant, tempCoef;
        boolean thereIsAllZero = false;
        boolean hasSolution = true;
        double[] solutionConst = new double[B.length];
        double[][] coefVar = new double[B.length][B.length]; // Col buat Partical Solution, row isinya coef dari masing2 parameter (s,t,...)
        char[] variable = new char[A.length];
        char mark = '`';
        totalRow = A[0].length;
        for (i = 0; i < A[0].length; i++) {
            if (isAllZero(A, i)) {
                thereIsAllZero = true;
                if (B[i] != 0) {
                    hasSolution = false;
                }
            }
        } // Checking tipe Solusi

        totalFreeVar = 0;
        initialASCII = 97;

        /* Isi array variable dengan mark, yaitu ` . Isi array solution dengan 0*/
        for (i = 0; i < totalRow; i++) {
            variable[i] = '`';
            solutionConst[i] = 0;
        }

        // Isi array coefVar dengan 0 semua

        for (i = 0; i < B.length; i++) {
            for (j = 0; j < B.length; j++) {
                coefVar[j][i] = 0;
            }
        }



        if (!(hasSolution)) {
            System.out.println("Tidak ada solusi");
        }
        else {
            for (i = (A[0].length) - 1; i >= 0; i--) {
                if (isAllZero(A, i)) {
                    totalFreeVar += 1;
                    variable[i] = Character.toUpperCase((char)initialASCII);
                    initialASCII += 1;
                    coefVar[i][A[0].length - i - 1 ] = 1;
                    System.out.println("X"+ (i+1) + " = " + variable[i]);
                }
                else {
                    tempConstant = B[i];
                    System.out.print("X" + (i+1) + " = ");
                    // Get full Constant, not just tempConstant
                    if (i != A[0].length - 1) {
                        for (j = (A.length) - 1; j > i; j--) {
                            if (variable[j] == mark) {
                                tempConstant -= A[j][i] * solutionConst[j];
                                for (k = 0; k < totalFreeVar; k++) {
                                    tempCoef = coefVar[i][k];
                                    tempCoef -= A[j][i] * coefVar[j][k];
                                    coefVar[i][k] = tempCoef;
                                }
                            }
                            else {

                                for (k = 0; k < totalFreeVar; k++) {
                                    tempCoef = coefVar[i][k];
                                    tempCoef -= A[j][i] * coefVar[j][k];
                                    coefVar[i][k] = tempCoef;
                                }

                            }
                            solutionConst[i] = tempConstant;
                        }
                    }
                    else {
                        solutionConst[i] = tempConstant;
                    }
                    // Printing the constant first
                    if (solutionConst[i] != 0) { 
                        System.out.print(df3.format(solutionConst[i]));
                    }

                    // Printing the variable with the coef, but the coef is still fucked up
                            loop = A.length - 1;
                            for (k = 0; k < totalFreeVar; k++) {
                                if (coefVar[i][k] > 0) {
                                    System.out.print(" + " + df3.format(Math.abs(coefVar[i][k])) + variable[loop]);
                                    loop--;
                                } 
                                else if (coefVar[i][k] < 0) {
                                    System.out.print(" - " + df3.format(Math.abs(coefVar[i][k])) + variable[loop]);
                                    loop--;
                                }

                            }
                    System.out.println("");
                } // End of Else
            }
        }
    } // End of solveSPL
    
    
    static double[] cramerSPL(double[][] M){// input augmented matrix
        GetDeterminant myDet = new GetDeterminant();
        double[][] MSmall = new double[M.length-1][M[0].length];
        double[] valDet = new double[M.length-1]; // Cramer Determinant
        double[] solusi = new double[M.length-1];
        double tempDet; // Determinant of M
        for(int j=0;j<M[0].length;j++){
            for(int i=0;i<M.length-1;i++){
                MSmall[i][j] = M[i][j];
            }
        }
        tempDet = myDet.gaussDeterminant(MSmall);
        for(int i = 0; i<M.length-1; i++){
            valDet[i] = myDet.cramerDeterminant(M,i);
            solusi[i] = valDet[i]/tempDet;
        }
        return solusi;
    }

}
