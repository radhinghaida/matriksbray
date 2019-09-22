import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class GetMatriks {
     /* public static void BacaFile() {
        String space = " ";
        int trash = 0; // Untuk mengisi index ke-0 dari array column
        int charAscii;
        int line = 1;
        int column = 1;
        char c;
        Scanner readFileName = new Scanner(System.in);
        String fileName = readFileName.nextLine();
        File myFile = new File(fileName);
        if (!(myFile.exists())) {
            System.out.println("File bernama " + fileName + " tidak ditemukan.\n");
        }
        int lenFile = myFile.length();
        FileReader fr = new FileReader(myFile);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<ArrayList<Float>> matrix = new ArrayList<ArrayList<Float>>();
        ArrayList<Float> column = new ArrayList<Float>();
        column.add(trash);
        matrix.add(column);
        while ((charAscii = br.read()) != -1) {
            if (br.read() == null) {
                line += 1;
                column = 1;
            }
            else if (br.read() != space) {
                matrix.add(column.add(br.read()));
            }
            else {
                
            }
        }
        br.close();
        fr.close();
        myFile.close();
    }
    */


    static void inputMatriks(double[][] A, double[] B, int m, int n) { // Akan dipindahkan ke file GetMatriks.java
        int i, j;
        Scanner input = new Scanner(System.in);
        for (j = 0; j < m; j++) {
            for (i = 0; i < m; i++) {
                A[i][j] = input.nextDouble();
            }

        }
        inputRightSide(B, m);
    }

    static void inputRightSide(double[] B, int m) { // Akan dipindahkan ke file GetMatriks.java
        int i;
        Scanner input = new Scanner(System.in);
        for (i = 0; i < m; i++) {
            B[i] = input.nextDouble();
        }
    }
}