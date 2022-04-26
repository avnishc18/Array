import java.util.Arrays;


public class MinCoins2 {
//    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 11;
        int[] a = {7, 5, 3};
        int[] minArr = new int[n+1];
        Arrays.fill(minArr, -1);
        System.out.println("Ans:" + minCoins(n,a, minArr));

    }

    static int minCoins(int n, int[] a, int[] minArr){
        //System.out.print(n + " ");
        if( n == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int j : a) {
            if (n - j >= 0) {
                int subAns;
                if (minArr[n-j] != -1) {
                    subAns = minArr[n-j];
                } else {
                    subAns = minCoins(n - j, a, minArr);
                    minArr[n-j] =  subAns;
                }
                if (subAns != Integer.MAX_VALUE && subAns + 1 < min) {
                    min = subAns + 1;
                }

            }
        }
        return minArr[n] = min;
    }
}
