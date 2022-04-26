public class findZeros {
    public static void main(String[] args) {
        int arr[] = {0};
        System.out.println(findZeroes(arr, arr.length, 1));
    }

    public static int findZeroes(int arr[], int n, int m) {
        // code here
        int maxlength = 0;

        int len = 0;
        int zc = 0;
        int j = 0;
        int i = 0;
        while (i < n && j< n){

            while(j < n && zc <= m){
                //System.out.print(arr[j] + " ");
                if(arr[j] == 0) zc++;
                j++;

            }
            if(zc > m) { j--; zc--;}
            len = j -i;
            //if(j < n) { j = j-2; len--; zc--;}
            //System.out.println("i:" + i + "j:" + j + " zc:" + zc);
            if(maxlength < len) {
                maxlength = len;
                //System.out.println("maxlength:" + maxlength);
            }

            while (i <= j &&  arr[i] != 0 ) {
                i++;
            }
            if(arr[i] == 0) { zc--; i++;}
            //System.out.println("i:" + i + "j:" + j + " zc:" + zc);
        }

        return maxlength;
    }
}
