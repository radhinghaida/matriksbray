import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.FileWriter;   
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

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


    static void SaveMatriksIntoFile(double[][] A) { 
        String fileName;
        int i, j;
        Scanner inputFileName = new Scanner(System.in);
        System.out.print("Masukkan nama file : ");
        fileName = inputFileName.nextLine();
        File myFile = new File(fileName + ".txt");
        try {
            if (!(myFile.exists())) {
                myFile.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(myFile, true));
            for (i = 0; i < A[0].length; i++) {
                for (j = 0; j < A.length; j++) {
                    if (j == (A.length-1)) {
                        out.append(A[j][i] + "\n");
                    }
                    else {
                        out.append(A[j][i] + " ");
                    }

                }
            } // End of Printing di File

            out.close();
            System.out.println("Sukses Bray!");
        }
        catch(IOException e){
            System.out.println("Gasabi bray");
        }
    }

        static void SaveInterpolasiEQIntoFile(String Eq, String address) { 
            int i, j;
            File myFile = new File(address + ".txt");
            try {
                if (!(myFile.exists())) {
                    myFile.createNewFile();
                }
                PrintWriter out = new PrintWriter(new FileWriter(myFile, true));
                out.append(Eq + "\n");
                out.close();
                System.out.println("Sukses Bray!");
            }
            catch(IOException e){
                System.out.println("Gasabi bray");
            }
     
    } 

    static void SaveInterpolasiIntoFile(double x, double y, String address) { 
        int i, j;
        File myFile = new File(address + ".txt");
        try {
            if (!(myFile.exists())) {
                myFile.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(myFile, true));
            out.append(x + " " + y + "\n");
            out.close();
            System.out.println("Sukses Bray!");
        }
        catch(IOException e){
            System.out.println("Gasabi bray");
        }
 
    } 

    static void SaveDeterminantIntoFile(double x) { 
        int i, j;
        String fileName;
        Scanner inputFileName = new Scanner(System.in);
        System.out.print("Masukkan nama file : ");
        fileName = inputFileName.nextLine();
        File myFile = new File(fileName + ".txt");
        try {
            if (!(myFile.exists())) {
                myFile.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(myFile, true));
            out.append("Determinan = " + x + " " + "\n");
            out.close();
            System.out.println("Sukses Bray!");
        }
        catch(IOException e){
            System.out.println("Gasabi bray");
        }
 
    }

    static void solveSPLSave(double[][] A, double[] B) { // Masih bermasalah kalo ada free variable
        int i, j, k, l, totalFreeVar, totalRow, initialASCII, loop;
        double tempConstant, tempCoef;
        boolean thereIsAllZero = false;
        boolean hasSolution = true;
        String fileName;
        double[] solutionConst = new double[B.length];
        double[][] coefVar = new double[B.length][B.length]; // Col buat Partical Solution, row isinya coef dari masing2 parameter (s,t,...)
        char[] variable = new char[B.length];
        char mark = '`';

        GaussEli gaussNoSave = new GaussEli();

        Scanner inputFileName = new Scanner(System.in);
        System.out.print("Masukkan nama file : ");
        fileName = inputFileName.nextLine();
        File myFile = new File(fileName + ".txt");
        try {
            PrintWriter out = new PrintWriter(new FileWriter(myFile, true));

        totalRow = A[0].length;
        for (i = 0; i < A[0].length; i++) {
            if (gaussNoSave.isAllZero(A, i)) {
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
                if (gaussNoSave.isAllZero(A, i)) {
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
                        out.append(df3.format(solutionConst[i]));
                    }

                    // Printing the variable with the coef, but the coef is still fucked up
                            loop = A.length - 1;
                            for (k = 0; k < totalFreeVar; k++) {
                                if (coefVar[i][k] > 0) {
                                    System.out.print(" + " + df3.format(Math.abs(coefVar[i][k])) + variable[loop]);
                                    out.append(" + " + df3.format(Math.abs(coefVar[i][k])) + variable[loop]);
                                    loop--;
                                } 
                                else if (coefVar[i][k] < 0) {
                                    System.out.print(" - " + df3.format(Math.abs(coefVar[i][k])) + variable[loop]);
                                    out.append(" - " + df3.format(Math.abs(coefVar[i][k])) + variable[loop]);
                                    loop--;
                                }

                            }
                    System.out.println("");
                    } // End of Else
                }
            } // End of Else (has Solution)
            out.close();
        } catch (Exception e) {
            System.out.println("Error bray");
        }
    } // End of solveSPL


}
