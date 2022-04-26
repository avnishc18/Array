import java.util.ArrayList;
import java.util.List;

public class RiverLength {
    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        System.out.println(riverSizes(input));
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        int visit[][] = new int[matrix.length][matrix[0].length];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(visit[i][j] == 1 || matrix[i][j] == 0){
                    continue;
                }else {
                    int num = visitNearBy(matrix,visit,i, j);
                    list.add(num);
                }
            }
        }
        return list;
    }

    static int visitNearBy(int[][] matrix,int[][] visit, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return 0;
        if(visit[x][y] == 1 || matrix[x][y] == 0){
            return 0;
        }else{
            visit[x][y] = 1;
            return 1 + visitNearBy(matrix, visit, x-1, y) +
                    visitNearBy(matrix, visit, x+1, y) +
                    visitNearBy(matrix, visit, x, y+1) +
                    visitNearBy(matrix, visit, x, y-1);
        }
    }
}
