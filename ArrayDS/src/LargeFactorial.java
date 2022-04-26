import java.util.Vector;

public class LargeFactorial {
    public static void main(String[] args) {
        long arr[] = {3, 10};
        print(factorial(arr, 2));
    }
    static Vector<Long> fact = new Vector<Long>();
    static int size = -1;
    static long MOD = 1000000007;
    public static long[] factorial(long a[], int n) {
        // code here
        for(int i = 0; i < n ; i++){
            if(size < a[i]) {
                size = (int)a[i];
            }
        }
        fact();
        int i = 0;
        while(i< n){
            a[i] = fact.get(Integer.parseInt(a[i]+""));i++;
        }
        return a;
    }

    static void fact(){
        fact.add((long)1);
        for(int i = 1; i <= size ; i++){
            fact.add((fact.get(i-1) * i) % MOD);
        }
    }

    private static void print(long[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
