public class Rearrange {
    public static void main(String[] args) {
        int arr[] = {9,4,-2,-1,5,0,-5,-3,2};
        for(int i =0; i < arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
        rearrange(arr, arr.length);
        for(int i =0; i < arr.length;i++){
            System.out.print(arr[i] +" ");
        }

    }

    static void rearrange(int arr[], int n) {
        // code here
        int i = 0; //for positive number;
        int j = i+1; // for negative number;

        while( i < n && j < n){
            j = i+1;
            if(i % 2 == 0){
                if(arr[i] >= 0) {i++;continue;}
                while(j < n && arr[j] < 0) j++;
                if(j < n && arr[j] > 0) {
                    for(int k =j; k > i; k--) swap(arr,k,k-1);
                    i++;
                }else break;
            }else {
                if(arr[i] < 0) {i++;continue;}
                while(j < n && arr[j] > 0) j++;
                if(j < n && arr[j] < 0) {
                    for(int k =j; k > i; k--) swap(arr,k,k-1);
                    i++;
                }
                else break;
            }
        }
    }
    static void swap(int a[], int x, int y){
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
}
