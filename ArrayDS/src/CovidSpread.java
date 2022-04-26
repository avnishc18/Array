import java.util.LinkedList;
import java.util.Queue;

public class CovidSpread {
    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 2, 2, 1},
                {0, 0, 0, 2, 1},
                {1, 0, 0, 2, 1},
                {1, 0, 0, 2, 1},
        };
        System.out.println(helpaterp(input));
    }
    static int helpaterp(int[][] matrix) {
        // code here
        int visit[][] = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < visit.length; i++) {
            for(int j = 0; j < visit[0].length; j++) {
                visit[i][j] = -1;
            }
        }
        Queue<Element> queue = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(visit[i][j] > -1 || matrix[i][j] < 2){
                    continue;
                }else {
                    visit[i][j] = 0;
                    queue.add(new Element(i,j));
                }
            }
        }
        visitNearBy(matrix,visit, queue);
        int max = 0;

        for(int i = 0; i < visit.length; i++) {
            for(int j = 0; j < visit[0].length; j++) {
                System.out.print(visit[i][j]+" ");
                if( max < visit[i][j]){
                    max = visit[i][j];
                }
            }
            System.out.println();
        }
        return max;
    }

    private static void visitNearBy(int[][] matrix, int[][] visit, Queue<Element> queue) {
        int[][] n = {
                { 1, -1, 0,  0},
                { 0,  0, -1, 1}
        };
        while(!queue.isEmpty()) {
            Element e = queue.remove();

            for(int i = 0;i< 4;i++) {
                int x = e.x + n[0][i]; int y = e.y+n[1][i];
                if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) continue;
                if(matrix[x][y] == 1 && visit[x][y] == -1) {
                    //System.out.println(x+" " + y);
                    visit[x][y] = visit[e.x][e.y] + 1;
                    queue.add(new Element(x,y));
                }

            }
        }
    }

    static class Element{
        public int x;
        public int y;
        Element(int x,int y){ this.x =x;this.y = y;}
    }

   // static void visitNearBy(int[][] matrix,int[][] visit, int x1, int y1, int infacted){

//        int[][] n = {
//                { 1, -1, 0,  0},
//                { 0,  0, -1, 1}
//        };
//        //System.out.println(x1+" " + y1);
//        for(int i = 0;i< 4;i++) {
//            int x = x1 + n[0][i]; int y = y1+n[1][i];
//            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) continue;
//            if(matrix[x][y] == 1 && visit[x][y] == 0) {
//                //System.out.println(x+" " + y);
//                visit[x][y] = infacted;
//                visitNearBy(matrix, visit, x, y, infacted+1);
//            }
//
//        }

  //  }

}
