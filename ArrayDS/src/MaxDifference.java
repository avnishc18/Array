public class MaxDifference {
    public static void main(String[] args) {
        int arr[] = {7, 9, 5, 6, 3, 2};
        System.out.println(findMaxDiff(arr,arr.length));

    }

    static int findMaxDiff(int arr[], int n){
        if( n == 1) return 0;
        int i = 0;
        int maxDiff= 0;
        while(i < n-1){
            while( i < n-1 && arr[i] >= arr[i+1]){
                i++;
            }
            if(i == n-1 ) return maxDiff;
            int first = i++;
            while( i < n-1 && arr[i] >= arr[i -1]){
                i++;
            }
            int second = i - 1;
            if( maxDiff < (arr[second] - arr[first])){
                maxDiff = arr[second] - arr[first];
            }
        }
        return maxDiff;
    }

}
