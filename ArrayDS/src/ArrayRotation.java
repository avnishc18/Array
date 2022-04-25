/**
 * A left rotation operation on an array shifts each of the array's elements  unit to the left. 
 * For example, if  left rotations are performed on array , then the array would become . 
 * Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array  of  integers and a number, , perform  left rotations on the array. 
Return the updated array to be printed as a single line of space-separated integers.

Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7

Output 3 4 5 6 7 1 2
 */


public class ArrayRotation {
    public static void main(String[] args) throws Exception {
       int arr[] = {1, 2, 3, 4, 5, 6, 7};
       print(arr);
       int d = 2;
       rotateArray(arr, d);
       print(arr);
    }

    private static void rotateArray(int[] arr, int d){
        int n = arr.length;
        d = d % n;
        int gcd = gcd(arr.length, d);
        int j,k, temp;
        
        for(int i =0; i< gcd; i++){
            temp = arr[i];
            j = i;
            while(true) {
                k = j + d;
                if( k >= n) {
                    k = k - n;
                }
                if( k == i){
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }

    }

    private static int gcd(int a, int b){
        if(b == 0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }

    private static void print(int[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
