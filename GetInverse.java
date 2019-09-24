public class GetInverse {

    static double[][] adjoinInverse(double[][]M) {
        double[][] MA = new double[M.length][M[0].Length]; // Menyimpan matriks Adjoin
        double[][] MI = new double[M.length][M[0].Length]; // Menyimpan matriks Inverse hasil
        double detM; // Menyimpan hasil determinan matriks M
        int i, j;
        GetCofactor myCofactor = new GetCofactor();
        GetDeterminant myDet = new GetDeterminant();
        MA = myCofactor.makeAdjMatrix(M);
        detM = myDet.cramerDeterminant(M);
        for (i = 0; i < M[0].length; i ++) {
            for (j = 0; j < M.length; j++) {
                MI[j][i] = MA[j][i]*detM;
            }
        }
    }
    return MI;

}
