public class GetDeterminant {

    static double cofDeterminant(double[][] M) {
        double[][] MP = new double[M.length-1][M[0].length - 1];
        double tempDet;
        int i, j, currentKol,currentBrs, chosenCol;
        boolean shifted;
        tempDet = 0;
        if (M.length == 2) {
            tempDet = (M[0][0] * M[1][1]) - (M[0][1] * M[1][0]);
            return tempDet; 
        }
        else {
            chosenCol = 0;
            for (currentKol = 0; currentKol < M.length; currentKol++) {
                for (i = 1; i < M[0].length; i++) { // i for row
                    shifted = false;
                    for (j = 0; j < M.length; j++) { // j for col
                        if (shifted) {
                            MP[j-1][i-1] = M[j][i];
                        }
                        else if (j == currentKol) {
                            shifted = true;
                        }
                        else {
                            MP[j][i-1] = M[j][i];
                        }
                        
                    }
                } 
                            
                tempDet += (M[chosenCol][0] * cofDeterminant(MP)) * Math.pow(-1,1+chosenCol);
                chosenCol += 1;
            }
            return tempDet;

        }

    } // End of cramerDet

    static double gaussDeterminant(double[][] M) {
        int i, j, chosenCol;
        double tempDet, multiplier;
        tempDet = 1;
        chosenCol = 0;
        while (chosenCol < M.length) {
            for (i = chosenCol+1; i < M[0].length; i++) {
                if (M[chosenCol][i] != 0) {
                    multiplier = M[chosenCol][i] / M[chosenCol][chosenCol];
                    for (j = chosenCol; j < M.length; j++) {
                        M[j][i] = M[j][i] - (multiplier) * M[j][chosenCol];
                    }
                }
            }
            chosenCol++;
        }
        for (i = 0; i < M.length; i++) {
            tempDet *= M[i][i];
        }

        return Math.round(tempDet);
    } // End of gaussDet
    
    static double cramerDeterminant(double[][] M, int n){// nilai n menunjukkan variable ke-n, dan input augmented matrix
        GaussEli myGauss = new GaussEli();
        GetDeterminant myDet = new GetDeterminant();
        double tempDet;
        double[][] MSwap = new double[M.length][M[0].length];
        double[][] MCoef = new double[M.length-1][M[0].length]; 
        MSwap = myGauss.CopyMatriks(M); 
        myGauss.SwapCol(MSwap, n, M.length-1);
        for(int j=0;j<M[0].length;j++){
            for(int i=0;i<M.length-1;i++){
                MCoef[i][j] = MSwap[i][j];
            }
        }
        tempDet = myDet.gaussDeterminant(MCoef);
        return tempDet;

    }

}
