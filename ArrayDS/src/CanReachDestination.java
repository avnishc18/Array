public class CanReachDestination {
    public static void main(String[] args) {
        int[] arr = {1,2,0,3,0,0};
        System.out.print(canReach(arr));
    }

    static int canReach(int[] arr){
        int len = arr.length;
        if(len == 1) return 1;
        int maxReach = arr[0];
        int i = 1;
        for(; i < len;i++){
            if(i == len -1) return 1;
            maxReach = Math.max(maxReach, i+arr[i]);
            if(i >= maxReach) return 0;
        }
        if(i == len -1) return 1;
        return 0;
    }

}
