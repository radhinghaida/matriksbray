 public class Cofactor{

    public static double[][] makeEntryMatrix(double[][] M, int a, int b){ // a and b are the selected index
        double[][] ME = new double[M.length-1][M[0].length-1];
        int k=0, l=0;
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j<M[0].length; j++){
                if(i == a-1 || j == b-1 ){ //a-1 and b-1 untuk menyelaraskan row column non program
                    continue; // Skip the selected index
                }else{
                    ME[k][l] = M[i][j];
                    l++;
                }
            }
            if(i != a-1 || j != b-1 ){ //a-1 and b-1 untuk menyelaraskan row column non program
                k++;
            }
        }
        return ME;
    }

    static double[][] makeCofMatrix(double[][] M){
        double[][] MCof = new double[M.length][M[0].length];
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j<M[0].length; j++){
                MCof[i][j] = gaussDeterminant(makeEntryMatrix(M,i+1,j+1));
            }
        }
        return MCof;
    }

    static double[][] makeAdjMatrix(double[][] M){
        double[][] AdjM = new double[M.length][M[0].length];
        int temp;
        for (int i = 0; i < M.length; i++) {
            for (int j = i; j < M[0].length; j++) {
                temp = M[i][j];
                M[i][j] = M[j][i];
                M[j][i] = temp;
            }
        }
        return AdjM;
    }
}    
