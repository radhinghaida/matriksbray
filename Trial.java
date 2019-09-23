import java.util.Scanner;

public class Trial {
    public static void main(String[] args) {
        int m,n;
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        double[][] A = new double[m][m];
        double[] B = new double[m];
        GetMatriks myMatriks = new GetMatriks();
       // GetDeterminant myDeterminant = new GetDeterminant();
        myMatriks.inputMatriks(A, m, n);
        System.out.println("Input Hasil SPL : ");
        myMatriks.inputRightSide(B, m);
        GaussEli Eli = new GaussEli();
        Output outMatrix = new Output();
        //System.out.print("Determinant Matriks Input : ");
        //System.out.println(myDeterminant.gaussDeterminant(A));
        outMatrix.printMatrix(A);
        Eli.GaussEli(A,B);
        System.out.println("");
        outMatrix.printMatrix(A);
        outMatrix.printHasilPersamaan(B);
        System.out.println("Solusi SPL : ");
        Eli.solveSPL(A, B);
        System.out.println("");
        System.out.println("Gauss Jordan : ");
        Eli.GaussJordan(A,B);
        System.out.println("");
        outMatrix.printMatrix(A);
        outMatrix.printHasilPersamaan(B);
    }

}