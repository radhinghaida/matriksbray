public class GetCofactor{

    public static double[][] makeEntryMatrix(double[][] M, int a, int b){ // a is for column and b is for row
        double[][] ME = new double[M.length-1][M[0].length-1];
        int k=0, l=0;
        for(int j = 0; j < M[0].length; j++){ // j for row
            for(int i = 0; i<M.length; i++){// i for column
                if((i == a) || (j == b)){
                    continue; // Skip the selected index
                }else{
                    ME[l][k] = M[i][j];
                    l++;
                }
            }
            if (j!=b){
                k++;
                l=0;
            }
        }
        return ME;
    }
    

    static double[][] makeCofMatrix(double[][] M){
        double[][] MCof = new double[M.length][M[0].length];
        GetDeterminant myDet = new GetDeterminant();
        for(int j = 0; j < M[0].length; j++){
            for(int i = 0; i<M.length; i++){
                if ((i+j)%2 == 0){
                    MCof[i][j] = myDet.gaussDeterminant(makeEntryMatrix(M,i,j));
                }else{
                    MCof[i][j] = (-1)*myDet.gaussDeterminant(makeEntryMatrix(M,i,j));
                }
            }
        }
        return MCof;
    }

    static double[][] makeAdjMatrix(double[][] M){//input square matrix
        double[][] AdjM = new double[M.length][M[0].length];
        double temp;
        AdjM = makeCofMatrix(M);
        for (int j = 0; j < M[0].length; j++)
        {
            for (int i = 0; i < j; i++)
            {
                temp = AdjM[i][j];
                AdjM[i][j] = AdjM[j][i];
                AdjM[j][i] = temp;
            }
        }
        return AdjM;
    }
}        
