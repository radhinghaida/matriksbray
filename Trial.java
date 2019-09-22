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
        myMatriks.inputMatriks(A, B, m, n);
        GaussEli Eli = new GaussEli();
        Output outMatrix = new Output();
        outMatrix.printMatrix(A);
        Eli.GaussEli(A,B);
        System.out.println("");
        outMatrix.printMatrix(A);
        outMatrix.printHasilPersamaan(B);
        
    }

}