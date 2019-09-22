import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Output {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    static void printMatrix(double[][] A) {
        int i, j, totalCol, totalRow;
        totalCol = A.length;
        totalRow = A[0].length;
        for (j = 0; j < totalRow; j++) {
            for (i = 0; i < totalCol; i++) {
                System.out.print(df2.format(A[i][j]) + " ");
            }
            System.out.println("");
        }
    }

    static void printHasilPersamaan(double[] B) {
        int i, totalRow;
        totalRow = B.length;
        for (i = 0; i < totalRow; i++) {
            System.out.println(df2.format(B[i]));
        }
    }

}