package graph.shortestpath;

public class _11_floyd_warshall {
    public static void main(String[] args) {
        //i=u and j=v. mat[i][j] = w
        //-1 means unreachable as of now
        //have to compute shortest distance for all nodes
        int[][] matrix = {
            {0, 2, -1, -1}, 
            {1, 0, 3, -1}, 
            {-1, -1, 0, 1}, 
            {3, 5, 4, 0}};
        
        int v = matrix.length;
        for(int via=0;via<v;via++){

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                 if (matrix[i][via]==-1 || matrix[via][j]==-1)
                    continue;

                 if (matrix[i][j]==-1) {
                    matrix[i][j] = matrix[i][via] + matrix[via][j];
                 }
                 else{
                    matrix[i][j] = Math.min(matrix[i][via] + matrix[via][j], matrix[i][j]);
                 }
                }
            }
        }
    }
}
