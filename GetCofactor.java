 public class GetCofactor{

    public static double[][] makeEntryMatrix(double[][] M, int a, int b){ // a is for column and b is for column
        double[][] ME = new double[M.length-1][M[0].length-1];
        int k=0, l=0;
        for(int j = 0; j < M.length; j++){ // j for row
            for(int i = 0; i<M[0].length; i++){// i for column
                if((i == a) || (j == b)){
                    continue; // Skip the selected index
                }else{
                    ME[l][k] = M[i][j];
                    l++;
                }
            }
            if(i != a){ 
                k++;
            }
        }
        return ME;
    }

    static double[][] makeCofMatrix(double[][] M){
        double[][] MCof = new double[M.length][M[0].length];
        GetDeterminant myDet = new GetDeterminant();
        for(int j = 0; j < M.length; j++){
            for(int i = 0; i<M[0].length; i++){
                MCof[i][j] = myDet.gaussDeterminant(makeEntryMatrix(M,i,j));
            }
        }
        return MCof;
    }

    static double[][] makeAdjMatrix(double[][] M){
        double[][] AdjM = new double[M.length][M[0].length];
        double temp;
        for (int j = 0; j < M.length; j++) {
            for (int i = j; i < M[0].length; i++) {
                temp = M[i][j];
                M[i][j] = M[j][i];
                M[j][i] = temp;
            }
        }
        return AdjM;
    }
}    
