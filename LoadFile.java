import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class LoadFile {
  public static double[][] LoadMatriks(int kolom, int row) throws IOException {

    double d;
    int countCol, countRow,i,j,x,y,a, countIsi;

    countCol = 0;
    countRow = 0;
    countIsi = 0;


     FileReader fin = new FileReader("tes.txt");
    Scanner src = new Scanner(fin);
    try {
    while (src.hasNext()) {
      
        if (src.hasNextDouble()) {
            d = src.nextDouble();
            countIsi += 1;
        } 
        else if (src.hasNextLine()) {
            src.nextLine();
            countRow += 1;
        }
    }
    fin.close();
    } catch (Exception e) {
        System.out.println("READ PERTAMA GAGAL BRAY");
    }

    FileReader finRow = new FileReader("tes.txt");
    Scanner srcRow = new Scanner(finRow);
    try {
    while (srcRow.hasNextLine()) {
            srcRow.nextLine();
            countRow += 1;
        }
    
    finRow.close();
    } catch (Exception e) {
        System.out.println("READ PERTAMA GAGAL BRAY");
    }

    countCol = countIsi/countRow;
    kolom = countCol;
    row = countRow;
    
    double[][] M = new double[countCol][countRow];
    FileReader finn = new FileReader("tes.txt");
    i = 0;
    j = 0;
    try {
    Scanner srcc = new Scanner(finn);


    for (i = 0; i < countRow; i++) {
        for (j = 0; j < countCol; j++) {
            M[j][i] = srcc.nextDouble();
        }
    }
    finn.close();
    } catch (Exception e) {
        System.out.println("READ KEDUA GAGAL BRAY");
    }
    return M;
  }

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
}
