import java.util.Scanner;

public class Output {
    
    static void printMatrix(double[][] A) {
        int i, j, totalCol, totalRow;
        totalCol = A.length;
        totalRow = A[0].length;
        for (j = 0; j < totalRow; j++) {
            for (i = 0; i < totalCol; i++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void printHasilPersamaan(double[] B) {
        int i, totalRow;
        totalRow = B.length;
        for (i = 0; i < totalRow; i++) {
            System.out.println(B[i]);
        }
    }

}