public class IslandCount {
    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        System.out.println(numIslands(input));
    }

    static int numIslands(int[][] matrix)
    {
        // Code here
        int visit[][] = new int[matrix.length][matrix[0].length];
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(visit[i][j] == 1 || matrix[i][j] == 0){
                    continue;
                }else {
                    visitNearBy(matrix,visit,i, j);
                    count++;
                }
            }
        }
        return count;
    }
    static void visitNearBy(int[][] matrix,int[][] visit, int x1, int y1){
        int[][] nodes = {
                {-1, -1, -1,  0, 0,  1, 1, 1},
                {-1,  0,  1, -1, 1, -1, 0, 1}
        };
        visit[x1][y1] = 1;
        for(int i = 0; i < 8; i++) {
            int x = x1+nodes[0][i];int y = y1+nodes[1][i];
            if(x< 0 || x >= matrix.length || y < 0 || y >= matrix[0].length ||
                    matrix[x][y] == 0 || visit[x][y] == 1) continue;
            //System.out.println(x +" " + y);
            visitNearBy(matrix, visit, x, y);
        }

    }
}
