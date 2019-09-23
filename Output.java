import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Output {

    private static DecimalFormat df3 = new DecimalFormat("#.###");

    static void printMatrix(double[][] A) {
        int i, j, totalCol, totalRow;
        totalCol = A.length;
        totalRow = A[0].length;
        for (j = 0; j < totalRow; j++) {
            for (i = 0; i < totalCol; i++) {
                if (df3.format(A[i][j]) == "-0") {
                    System.out.print(Math.round(A[i][j]) + " ");
                }
                else {
                    System.out.print(df3.format((A[i][j])) + " ");
                }
            }
            System.out.println("");
        }
    }

    static void printHasilPersamaan(double[] B) {
        int i, totalRow;
        totalRow = B.length;
        for (i = 0; i < totalRow; i++) {
            System.out.println(df3.format(B[i]));
        }
    }

}