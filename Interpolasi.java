import java.util.Scanner;

public class Interpolasi {
    static void approx(double[][] A, double[] B) {
        int i;
        double x;
        double temp = 0;
        double[] sol = new double[B.length];
        Scanner inputVal = new Scanner(System.in);
        GaussEli eli = new GaussEli();
        eli.GaussEli(A, B);
        sol = solveInterpolasi(A, B);
        System.out.print("P(x) = ");
        for (i = 0; i < sol.length; i++) {
            if (i == 0) {
                if (sol[i] > 0) {
                    if (sol[i+1] > 0) {
                        System.out.print(Math.abs(sol[i]) + " + ");
                    }
                    else {
                        System.out.print("-" + Math.abs(sol[i]) + " ");
                    }
                }
                else if (sol[i] < 0) {
                    if (sol[i+1] > 0) {
                        System.out.print("-" + Math.abs(sol[i]) + " + ");
                    }
                    else {
                        System.out.print("-" + Math.abs(sol[i]) + " ");
                    }
                }
                else { // sol[i] == 0
                    continue;
                }
            }
            else if (i == 1) {
                if (sol[i] > 0) {
                    System.out.print(Math.abs(sol[i]) + "x" + " ");
                }
                else if (sol[i] < 0) {
                    System.out.print("- " + Math.abs(sol[i]) + "x" + " ");
                }
                else { // sol[i] == 0
                    continue;
                }
            }
            else {
                if (sol[i] > 0) {
                    System.out.print(Math.abs(sol[i]) + "x^" + i + " ");
                }
                else if (sol[i] < 0) {
                    System.out.print("- " + Math.abs(sol[i]) + "x^" + i + " ");
                }
                else { // sol[i] == 0
                    continue;
                }
            }
        } // End of For, untuk ngeprint fungsinya
        System.out.println("");
        System.out.print("Masukkan x = ");
        x = inputVal.nextDouble();
        for (i = 0; i < sol.length; i++) {
            if (i == 0) {
                temp += sol[i];
            }
            else {
                temp += sol[i] * Math.pow(x,i);
            }
        }
        System.out.println("Hasil interpolasi = " + temp);
    }

    static double[] solveInterpolasi(double[][] A, double[] B) { // Masih bermasalah kalo ada free variable
        int i, j, totalRow;
        double tempConstant;
        double[] solutionConst = new double[B.length];
        totalRow = A[0].length;
        for (i = (A[0].length) - 1; i >= 0; i--) {
            tempConstant = B[i];
            // Get full Constant, not just tempConstant
            if (i != A[0].length - 1) {
                for (j = (A.length) - 1; j > i; j--) {
                    tempConstant -= A[j][i] * solutionConst[j];
                    solutionConst[i] = tempConstant;
                }
            }
            else {
                solutionConst[i] = tempConstant;
            }
        }
        return solutionConst;
    } // End of solveInterpolasi

}
