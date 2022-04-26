import java.util.Arrays;


public class MaxCoins {
//    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 11;
        int[] arr = new int[n+1];
        int[] a = {3,5,8};
        Arrays.fill(arr, Integer.MAX_VALUE);

        System.out.println();
        System.out.println(maxCoins(n, a, arr));
        for(int j:arr) {
            System.out.print(j + " ");
        }
    }

    public static int maxCoins(int n, int[] a, int[] arr){
        if(n == 0) {
            return 0;
        }
        int max = -1;
        for(int seg: a){
            int subAns;
            if(n- seg >= 0){
                if(arr[n-seg] != Integer.MAX_VALUE) {
                    subAns = arr[n-seg];
                }else {
                    subAns = maxCoins(n-seg, a, arr);
                    arr[n-seg] = subAns;
                }
                if(subAns != -1 && subAns + 1 > max )
                    max = subAns + 1;
            }
        }
        return arr[n] = max;
    }
}
